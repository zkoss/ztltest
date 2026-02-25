import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2811990TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2811990TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="My First Window" border="normal" width="600px">
			<html><![CDATA[
			<ol>
			<li>Move mouse to the Slider\'s nob, the tooltiptext shall be "50"; if it
			does not show, it is a bug</li>
			<li>Drag the nob of the slider to "70"; move mouse to slider\'s nob, the
			tooltiptext shall be "70"; if it does not showw, it is a bug</li>
			<li>Press button to change curpos to 10</li>
			<li>Move mouse to the Slider\'s nobe, the tooltiptext shall be "10"; if it
			is NOT "10", it is a bug.</li>
			</ol>
			]]>
			</html>
			<slider id="sl" curpos="50"/>
			<button label="change slider\'s curpos to 10" onClick="sl.curpos=10"/>
			</window>`,
	);
	await t
		.expect(ztl.normalizeText("50"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("$sl")).$n("btn")).attr("title"),
				)(),
			),
		);
	await t
		.drag(
			Selector(() => jq(zk.Widget.$(jq("$sl")).$n("btn"))[0]),
			37,
			2,
			{ offsetX: 8, offsetY: 6 },
		)
		.wait(1000);
	await t
		.expect(ztl.normalizeText("70"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("$sl")).$n("btn")).attr("title"),
				)(),
			),
		);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("10"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("$sl")).$n("btn")).attr("title"),
				)(),
			),
		);
});
