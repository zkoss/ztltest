import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F60-ZK-621TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F60-ZK-621TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div height="15px" />
				<div height="25px">Open combobox (the left one).</div>
				<div height="25px">You should see the message become \'message: combobox is open? true\'.</div>
				<div height="25px">Close combobox (the left one).</div>
				<div height="25px">You should see the message become \'message: combobox is open? false\'.</div>
				<div height="25px">Test above steps for the bandbox (the right one).</div>
				<combobox id="cbx">
					<attribute name="onOpen">
						lb.setValue("message: combobox is open? " + self.isOpen());
					</attribute>
					<comboitem label="Simple and Rich"/>
					<comboitem label="Cool!"/>
					<comboitem label="Ajax and RIA"/>
				</combobox>
				<bandbox id="bd">
					<attribute name="onOpen">
						lb.setValue("message: bandbox is open? " + self.isOpen());
					</attribute>
					<bandpopup>
						<listbox width="200px">
							<listhead>
								<listheader label="Name" />
								<listheader label="Description" />
							</listhead>
							<listitem>
								<listcell label="John" />
								<listcell label="CEO" />
							</listitem>
						</listbox>
					</bandpopup>
				</bandbox>
				<label id="lb" value="message: " />
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("cbx", true).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).$n().innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("message: combobox is open? true"),
			"You should see the message become 'message: combobox is open? true'.",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("cbx", true).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).$n().innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("message: combobox is open? false"),
			"You should see the message become 'message: combobox is open? false'.",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("bd", true).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).$n().innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("message: bandbox is open? true"),
			"You should see the message become 'message: bandbox is open? true'.",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("bd", true).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).$n().innerHTML,
				)(),
			),
		)
		.contains(
			ztl.normalizeText("message: bandbox is open? false"),
			"You should see the message become 'message: bandbox is open? false'.",
		);
});
