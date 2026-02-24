import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1718TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1718TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	Open the calendar, should see the "dates" after 2013/4/20 are disabled.
	<zscript><![CDATA[
		import java.util.Calendar;
		import java.util.Date;
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 3, 19);
		Date date = cal.getTime();
	]]></zscript>
	<datebox width="150px" value="\${date}" constraint="no empty, before 20130420" />
</zk>`,
	);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-datebox:eq(0)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-calendar-body td:contains(21)").hasClass("z-calendar-disabled"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0)
		.ok("should see the 2013/4/21 after 2013/4/20 are disabled.");
	let verifyVariable_cafe_0_0t = await ClientFunction(() =>
		jq(".z-calendar-body td:contains(22)").hasClass("z-calendar-disabled"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0t)
		.ok("should see the 2013/4/22 after 2013/4/20 are disabled.");
	let verifyVariable_cafe_0_0tt = await ClientFunction(() =>
		jq(".z-calendar-body td:contains(23)").hasClass("z-calendar-disabled"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0tt)
		.ok("should see the 2013/4/23 after 2013/4/20 are disabled.");
	let verifyVariable_cafe_0_0ttt = await ClientFunction(() =>
		jq(".z-calendar-body td:contains(24)").hasClass("z-calendar-disabled"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0ttt)
		.ok("should see the 2013/4/24 after 2013/4/20 are disabled.");
	let verifyVariable_cafe_0_0tttt = await ClientFunction(() =>
		jq(".z-calendar-body td:contains(25)").hasClass("z-calendar-disabled"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0tttt)
		.ok("should see the 2013/4/25 after 2013/4/20 are disabled.");
	let verifyVariable_cafe_0_0ttttt = await ClientFunction(() =>
		jq(".z-calendar-body td:contains(26)").hasClass("z-calendar-disabled"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0ttttt)
		.ok("should see the 2013/4/26 after 2013/4/20 are disabled.");
	let verifyVariable_cafe_0_0tttttt = await ClientFunction(() =>
		jq(".z-calendar-body td:contains(27)").hasClass("z-calendar-disabled"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0tttttt)
		.ok("should see the 2013/4/27 after 2013/4/20 are disabled.");
	let verifyVariable_cafe_0_0ttttttt = await ClientFunction(() =>
		jq(".z-calendar-body td:contains(28)").hasClass("z-calendar-disabled"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0ttttttt)
		.ok("should see the 2013/4/28 after 2013/4/20 are disabled.");
	let verifyVariable_cafe_0_0tttttttt = await ClientFunction(() =>
		jq(".z-calendar-body td:contains(29)").hasClass("z-calendar-disabled"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0tttttttt)
		.ok("should see the 2013/4/29 after 2013/4/20 are disabled.");
	let verifyVariable_cafe_0_0ttttttttt = await ClientFunction(() =>
		jq(".z-calendar-body td:contains(30)").hasClass("z-calendar-disabled"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0ttttttttt)
		.ok("should see the 2013/4/30 after 2013/4/20 are disabled.");
});
