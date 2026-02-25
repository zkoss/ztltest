import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1660TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1660TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<zscript><![CDATA[
import java.util.*;
import org.zkoss.zul.*;
public class Shop {
	private Integer id;
	private String nameShop;
	
	public Shop(Integer id, String nameShop) {
		this.id = id;
		this.nameShop = nameShop;
	}
	public Integer getId() {
		return id;
	}
	public String getNameShop() {
		return nameShop;
	}
	public String toString() {
		return nameShop;
	}
}
List listShop = new ArrayList();
for (int i = 0; i < 5; i++)
	listShop.add(new Shop(i, "SHOP - " + i));

ListModelList model = new ListModelList(listShop);
]]></zscript>
	<window title="Chosen Box" border="normal">
		<label multiline="true">
		1. Type "S" in the chosenbox and select "SHOP - 0".
		2. Click "test" button, should see "SHOP - 0" still remain in chosenbox.
		</label>
		<chosenbox id="cb" model="\${model}" width="400px" noResultsText="No such item - {0}"></chosenbox>
		<button label="test" onClick="alert(cb.getSelectedObjects())" />
	</window>
</zk>`,
	);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-chosenbox")).$n("inp"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => zk.Widget.$(jq(".z-chosenbox")).$n("inp")),
		);
	await ztl.waitResponse(t);
	await t.pressKey("S");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-chosenbox-option:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(test)")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-messagebox-window").find(".z-button:eq(0)")[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-chosenbox-item:contains(SHOP - 0)")[0],
			)(),
		)
		.ok("should see 'SHOP - 0' still remain in chosenbox.");
});
