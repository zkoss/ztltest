import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2837303TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2837303TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			You should see the height of the progressmeter is 10px height.
			<progressmeter height="10px"  width="95%" value="50" />
			For example, The bottom progressmeter is bigger than 10px height.
			<progressmeter width="95%" value="50" />
			</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@progressmeter:eq(0)").outerHeight(),
				)(),
			),
		)
		.eql(ztl.normalizeText("10"));
	const shortMeter = Selector(".z-progressmeter")
		.nth(0)
		.addCustomDOMProperties({
			fillShownInside: (meter) => {
				const fill = meter.querySelector(".z-progressmeter-image");
				return (
					getComputedStyle(meter).overflowY !== "visible" ||
					fill.getBoundingClientRect().bottom <=
						meter.getBoundingClientRect().bottom
				);
			},
		});
	await t
		.expect(shortMeter.fillShownInside)
		.ok(
			"the 10px progressmeter should show its fill only inside its height",
		);
	if ((await ClientFunction(() => zk.themeName)()) === "iceblue") {
		await t
			.expect(Selector(".z-progressmeter").nth(1).offsetHeight)
			.gt(
				10,
				"under IceBlue the default progressmeter should be taller than 10px",
			);
	}
});
