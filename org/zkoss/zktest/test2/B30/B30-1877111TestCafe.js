import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1877111TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1877111TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<html>
					<![CDATA[ <ol> <li>Type 12-13-98 in the first datebox</li>
					<li>Type TAB to move focus away</li> </ol> Then, an error
					message shall show up. However, no error message in the second
					one. ]]>
				</html>
				<hbox>
					lenient=false, MM.dd.yy:
					<datebox id="d" format="MM.dd.yy" lenient="false" />
				</hbox>
				<hbox>
					lenient=true, MM.dd.yy:
					<datebox id="d2" format="MM.dd.yy" lenient="true" />
				</hbox>
				<hbox>
					lenient=false, MMM d, yyyy:
					<datebox id="d3" format="MMM d, yyyy" lenient="false" />
				</hbox>
				<zscript>
				    d.focus();
				</zscript>
			</zk>`,
	);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-datebox:eq(0)")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => zk.Widget.$(jq(".z-datebox:eq(0)")).$n("real")),
		);
	await ztl.waitResponse(t);
	await t.pressKey("1 2 - 1 3 - 9 8 tab");
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
	await t.click(Selector(() => zk.Widget.$(jq(".z-errorbox")).$n("cls")));
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-datebox:eq(1)")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => zk.Widget.$(jq(".z-datebox:eq(1)")).$n("real")),
		);
	await ztl.waitResponse(t);
	await t.pressKey("1 2 - 1 3 - 9 8 tab");
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-datebox:eq(2)")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => zk.Widget.$(jq(".z-datebox:eq(2)")).$n("real")),
		);
	await ztl.waitResponse(t);
	await t.pressKey("1 2 - 1 3 - 9 8 tab");
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
});
