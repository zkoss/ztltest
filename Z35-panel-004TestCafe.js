import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z35-panel-004TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z35-panel-004TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
			<panel id="p1" title="Panel Component" border="normal" width="500px" maximizable="true" minimizable="true">
				<panelchildren>
					<grid width="100%">
						<columns>
							<column label="Name" />
							<column label="Description" />
						</columns>
						<rows>
							<row>
								<label value="Ivan" />
								<label value="MIS" />
							</row>
							<row>
								<label value="ohpizz" />
								<label value="Testing" />
							</row>
						</rows>
					</grid>
				</panelchildren>
			</panel>
					<button id="btn1" label="Change maximized">
						<attribute name="onClick">
								p1.maximized=!p1.maximized;
						</attribute>
					</button>
					<button id="btn2" label="Close">
						<attribute name="onClick">
							p1.open = !p1.open;
							self.label = p1.open == true ? "close" : "open";
						</attribute>
					</button>
					<button id="btn3" label="Change minimized">
						<attribute name="onClick">
								p1.minimized=!p1.minimized;
						</attribute>
					</button>
				<separator />	
				1. Click "Change maximized" button. There shouldn\'t be a space between panel and bottons.
				<separator />
				2. Then click "Close" button and open it. The space is disappeared.
				<separator />
				3. Then click "Change minimized" twice. The panel\'s layout shouldn\'t be out of expected.
			</window>`,
	);
	let width_cafe = await ClientFunction(() => jq("$p1").outerWidth())();
	await t.click(Selector(() => jq("$btn1")[0]));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$p1").outerWidth())(),
			),
		)
		.notEql(ztl.normalizeText(width_cafe), "");
	await t
		.expect(
			await ClientFunction(() => jq(".z-panel-body").is(":visible"))(),
		)
		.ok();
	await t.click(Selector(() => jq("$btn2")[0]));
	await ztl.waitResponse(t);
	await t.wait(800);
	await t
		.expect(
			await ClientFunction(() => jq(".z-panel-body").is(":visible"))(),
		)
		.notOk();
	await t.click(Selector(() => jq("$btn2")[0]));
	await ztl.waitResponse(t);
	await t.wait(800);
	await t
		.expect(
			await ClientFunction(() => jq(".z-panel-body").is(":visible"))(),
		)
		.ok();
	await t.click(Selector(() => jq("$btn3")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-panel").is(":visible"))())
		.notOk();
	await t.click(Selector(() => jq("$btn3")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-panel").is(":visible"))())
		.ok();
});
