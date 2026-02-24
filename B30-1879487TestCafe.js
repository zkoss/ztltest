import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1879487TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1879487TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>There are two situations in which this events happen</n:p>
				<n:ol>
					<n:li>
						After loading zul, please drop down the list of items and click
						outside of the combobox (for example in order to close dropped
						down list without any selection) the onSelect event should not fire
						and messagebox \'on select: item is null\' shouldn\'t appear.
					</n:li>
					<n:li>
						After loading zul, please focus in combobox, and then click on the \'anyMessage\' button.
						It should not show any messages about the onSelect event. It should show "anyMessage".
					</n:li>
				</n:ol>
				<vbox>
					<combobox id="cb1" constraint="strict"
						onSelect="Messagebox.show(self.selectedItem != null ?\n			self.selectedItem.value : &quot; on select: item is null&quot;);">
						<comboitem label="aaa" value="1" />
						<comboitem label="bbb" value="2" />
					</combobox>
					<zscript>
			
					</zscript>
					<button label="anyMessage"
						onClick="Messagebox.show(&quot;anyMessage&quot;)" />
				</vbox>
			</zk>`,
	);
	await t.click(
		Selector(() => jq(zk.Widget.$(jq(".z-combobox")).$n("btn"))[0]),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq("p")[0]),
		{ offsetX: 3, offsetY: 3 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox")[0])())
		.notOk();
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox .z-label").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("anyMessage"));
});
