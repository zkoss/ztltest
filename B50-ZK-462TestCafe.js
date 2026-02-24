import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-462TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-462TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<html><![CDATA[
			<ol>
			<li>Click \'reset label\' button, the label should become \'nothing happened\'.</li>
			<li>Click each checkbox twice, the label should not be changed.</li>
			<li>Maximize/Restore window by click the maximize/restore icon on the window, the label should become \'oops, test win maximized\'.</li>
			</ol>
			]]></html>
				<div width="800px" height="500px">
					<label id="lb" value="nothing happened" />
					<button id="btn1" label="reset label">
						<attribute name="onClick">
							lb.setValue("nothing happened");
						</attribute>
					</button>
					<checkbox id="cb1" label="maximizable" checked="true" onCheck="win.setMaximizable(self.checked);" />
					<checkbox id="cb2" label="minimizable" onCheck="win.setMinimizable(self.checked);" />
					<checkbox id="cb3" label="closable" onCheck="win.setClosable(self.checked);" />
					<checkbox id="cb4" label="border" checked="true">
						 <attribute name="onCheck">
						 	if (self.checked)
						 		win.setBorder("normal");
						 	else
						 		win.setBorder("none");
						 </attribute>
					</checkbox>
					<window id="win" title="test win" maximizable="true" maximized="true" border="normal">
						<attribute name="onMaximize">
							lb.setValue("oops, test win maximized!");
						</attribute>
					</window>
				</div>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t.expect("false").ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("cb1", true).$n("real")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("cb1", true).$n("real")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("cb2", true).$n("real")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("cb2", true).$n("real")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("cb3", true).$n("real")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("cb3", true).$n("real")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("cb4", true).$n("real")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("cb4", true).$n("real")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).$n().innerHTML,
				)(),
			),
		)
		.eql(ztl.normalizeText("nothing happened"));
	await t.click(Selector(() => zk.Desktop._dt.$f("win", true).$n("max")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).$n().innerHTML,
				)(),
			),
		)
		.eql(ztl.normalizeText("oops, test win maximized!"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).$n().innerHTML,
				)(),
			),
		)
		.eql(ztl.normalizeText("nothing happened"));
	await t.click(Selector(() => zk.Desktop._dt.$f("win", true).$n("max")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lb", true).$n().innerHTML,
				)(),
			),
		)
		.eql(ztl.normalizeText("oops, test win maximized!"));
});
