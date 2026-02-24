import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-569TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-569TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<hbox>
			<div width="20px">1.</div><label value="Select item \'test 7\'" />
			</hbox>
			<separator/>
			<hbox>
			<div width="20px">2.</div><label value="Click button \'show selection\', you should see a message box contains" />
			</hbox>
			<separator/>
			<hbox>
			<div width="20px"></div><label value="Selected index: 10, label of selected item: test 7" />
			</hbox>
			<separator/>
			<hbox>
			<div width="20px">3.</div><label value="Click \'OK\' to close the message box then Click button \'set 333 selected\'" />
			</hbox>
			<separator/>
			<hbox>
			<div width="20px">4.</div><label value="Click button \'show selection\', you should see a message box contains" />
			</hbox>
			<separator/>
			<hbox>
			<div width="20px"></div><label value="Selected index: 4, label of selected item: test 333" />
			</hbox>
			<separator/>
				<div>
					<listbox id="lb" mold="select">
						<listitem label="test 1" visible="false"/>
						<listitem label="test 2" visible="false"/>
						<listitem label="test 3"/>
						<listitem label="test 33"/>
						<listitem id="fff" label="test 333"/>
						<listitem label="test 3333"/>
						<listitem label="test 4" visible="false"/>
						<listitem label="test 5"/>
						<listitem label="test 555"/>
						<listitem label="test 6" visible="false"/>
						<listitem id="item7" label="test 7"/>
						<listitem label="test 7555"/>
						<listitem label="test 8" visible="false"/>
					</listbox>
					<button id="btn1" label="show selection">
						<attribute name="onClick">
							alert("Selected index: " + lb.getSelectedIndex() + ", label of selected item: " + lb.getSelectedItem().getLabel());
						</attribute>
					</button>
					<button id="btn2" label="set 333 selected">
						<attribute name="onClick">
							lb.setSelectedItem(fff);
						</attribute>
					</button>
				</div>
			</zk>`,
	);
	await t
		.click(Selector(() => jq(zk.Desktop._dt.$f("lb", true))[0]))
		.click(
			Selector(
				() =>
					jq(zk.Desktop._dt.$f("lb", true)).find(
						"option:contains(test 7)",
					)[0],
			),
		)
		.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				"Selected index: 10, label of selected item: test 7",
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window")
						.find(".z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				"Selected index: 4, label of selected item: test 333",
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window")
						.find(".z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
});
