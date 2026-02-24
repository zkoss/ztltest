import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1510218TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1510218TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<window id="win" title="root" border="normal">
					<zscript>
					void popup(){
						Window w=new Window();
						w.setId("inner1");
						w.setTitle("popup");
						w.setBorder("normal");
						w.setHeight("200px");
						w.setWidth("200px");
						w.setSizable(true);
						w.setStyle("overflow:visible;");
						w.setPage(page);
						w.appendChild(btn1);
						w.doPopup();
					}
					void overlapped(){
						Window w=new Window();
						w.setId("inner2");
						w.setTitle("oeverlapped");
						w.setSizable(true);
						w.setStyle("overflow:visible;");
						w.setHeight("200px");
						w.setWidth("200px");
						w.setBorder("normal");
						w.setPage(page);
						w.appendChild(btn2);
						w.doOverlapped();
					}
					</zscript>
					<button id="popup" label="popup" onClick="popup()"/>
					<button id="overlapped" label="overlapped" onClick="overlapped()"/>
					<button id="btn1" label="Btn1" onClick=\'alert("btn1 OK")\'/>
					<button id="btn2" label="Btn2" onClick=\'alert("btn2 OK")\'/>
				</window>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("popup", true).$n()));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("inner1", true).$n()),
		{ offsetX: 5, offsetY: 5 },
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("inner1", true)).is(":visible"),
			)(),
		)
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox > span").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("btn1 OK"));
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-window-highlighted")).$n("close")),
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("inner1", true)).is(":visible"),
			)(),
		)
		.notOk();
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("overlapped", true).$n()));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("inner2", true).$n()),
		{ offsetX: 5, offsetY: 5 },
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("inner2", true)).is(":visible"),
			)(),
		)
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox > span").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("btn2 OK"));
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-window-highlighted")).$n("close")),
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("inner2", true)).is(":visible"),
			)(),
		)
		.ok();
});
