import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3106676TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3106676TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<datebox id="dtbx1" constraint="no past" lenient="false"/>
			-> Correct. You cannot select past days.
			
			<datebox  id="dtbx2" constraint="no empty, no past" lenient="false"/>
			-> Correct. You cannot select past days as well.
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("dtbx1", true).$n("btn")));
	await ztl.waitResponse(t);
	let today_cafe = parseInt(
		await ClientFunction(() =>
			jq(".z-calendar-selected").last().text().replace(/\s/g, " "),
		)(),
	);
	let yesterday_cafe = parseInt(
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("dtbx1", true).$n("pp"))
					.find(".z-calendar-disabled")
					.last()[0].innerHTML,
		)(),
	);
	await t
		.expect(
			today_cafe - yesterday_cafe == 1 ||
				(today_cafe == 1 && 31 - yesterday_cafe <= 3),
		)
		.ok("the last unselectable date should be yesterday");
	await t.click(Selector(() => zk.Desktop._dt.$f("dtbx2", true).$n("btn")));
	await ztl.waitResponse(t);
	let today_cafet = parseInt(
		await ClientFunction(() =>
			jq(".z-calendar-selected").last().text().replace(/\s/g, " "),
		)(),
	);
	let yesterday_cafet = parseInt(
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("dtbx2", true).$n("pp"))
					.find(".z-calendar-disabled")
					.last()[0].innerHTML,
		)(),
	);
	await t
		.expect(
			today_cafet - yesterday_cafet == 1 ||
				(today_cafet == 1 && 31 - yesterday_cafet <= 3),
		)
		.ok("the last unselectable date should be yesterday");
});
