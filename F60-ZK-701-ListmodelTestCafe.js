import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F60-ZK-701-ListmodelTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F60-ZK-701-ListmodelTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<vbox id="vb">
					1. Please select one item on the list.
					<separator />
					2. Press the "Clone" button (it should not show any exception)
					<separator />
					3. Please select another item on the top list and then click the top head to sort it.
					<separator />
					4. The sorting and the selection cannot apply to the bottom list. (That is the feature)
					<button id="btn" label="Clone">
						<attribute name="onClick">{
							Object l = grid.clone();
							l.setId("dst" + ++cnt);
							vb.insertBefore(l, self);
							}</attribute>
					</button>
					<zscript><![CDATA[
			import org.zkoss.zk.ui.util.ComponentCloneListener;
			  int cnt = 0;
			String[] data = new String[10];
			for (int i = 0; i < data.length; i++)
				data[i] = "option " + i;
			
			public class CloneableModel extends ListModelList implements ComponentCloneListener, Cloneable {
				public CloneableModel(String[] d) {
					super(d);
				}
				public Object willClone(Component comp) {
					return clone();
				}
			}
			CloneableModel model = new CloneableModel(data);
			    ]]></zscript>
					<listbox id="grid" model="\${model}" onSelect="">
						<listhead>
							<listheader label="column" sort="auto" />
						</listhead>
					</listbox>
				</vbox>
			</zk>`,
	);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("grid", true)).find(
					".z-listitem:contains(option 3)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("grid", true).$n()).find(
				".z-listitem-selected:contains(option 3)",
			)[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0)
		.ok("The item contains option 3 should be selected");
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() =>
			!!jq(zk.Widget.$(jq(".z-listbox").eq(0)).$n()).find(
				".z-listitem-selected:contains(option 3)",
			)[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0t)
		.ok("The item contains option 3 should be selected");
	await t.click(
		Selector(
			() =>
				jq(zk.Widget.$(jq(".z-listbox").eq(0))).find(
					".z-listitem:contains(option 0)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Widget.$(jq(".z-listbox").eq(0))).find(
					".z-listheader:contains(column)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Widget.$(jq(".z-listbox").eq(0))).find(
					".z-listheader:contains(column)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("grid", true).$n()).find(
				".z-listitem-selected:contains(option 0)",
			)[0],
	)();
	await t
		.expect(verifyVariable_cafe_1_1)
		.notOk("The item contains option 0 should not be selected");
	let verifyVariable_cafe_0_0tt = await ClientFunction(
		() =>
			!!jq(zk.Widget.$(jq(".z-listbox").eq(0)).$n()).find(
				".z-listitem-selected:contains(option 0)",
			)[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0tt)
		.ok("The item contains option 0 should be selected");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("grid", true)).find(
							".z-listitem",
						)[0].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("option 0"),
			"The 0 th element should contains option 0",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Widget.$(jq(".z-listbox").eq(0))).find(
							".z-listitem",
						)[9].innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("option 0"),
			"The 9 th element should contains option 0",
		);
});
