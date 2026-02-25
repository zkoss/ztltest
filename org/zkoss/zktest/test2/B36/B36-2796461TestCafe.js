import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2796461TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2796461TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<style>
			.z-calendar {
				width: 360px;
			}
			.z-calendar-cell {
			   font-size: 20px;
			}
			</style>
			Please press the icon on the right of the box, and then the popup should not appear with a scroll bar.
			<datebox id="db"/>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("db", true).$n("btn")));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			parseInt(
				await ClientFunction(
					() => zk.Desktop._dt.$f("db", true).$n("pp").scrollHeight,
				)(),
			),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("db", true).$n("pp")).outerHeight(),
			)(),
		),
		ztl.normalizeText("6"),
	);
});
