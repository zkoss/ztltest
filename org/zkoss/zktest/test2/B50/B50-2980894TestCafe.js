import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2980894TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2980894TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<datebox id="db" readonly="true" />`);
	await t.click(Selector(() => zk.Desktop._dt.$f("db", true).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(zk.Desktop._dt.$f("db", true).$n("pp").firstChild),
			).$n("ty"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Widget.$(
							jq(
								zk.Desktop._dt.$f("db", true).$n("pp")
									.firstChild,
							),
						).$n("mid").className,
				)(),
			),
		)
		.contains(ztl.normalizeText("z-calendar-year"), "");
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(zk.Desktop._dt.$f("db", true).$n("pp").firstChild),
			).$n("y0"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Widget.$(
							jq(
								zk.Desktop._dt.$f("db", true).$n("pp")
									.firstChild,
							),
						).$n("mid").className,
				)(),
			),
		)
		.contains(ztl.normalizeText("z-calendar-mon"), "");
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(zk.Desktop._dt.$f("db", true).$n("pp").firstChild),
			).$n("m0"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Widget.$(
							jq(
								zk.Desktop._dt.$f("db", true).$n("pp")
									.firstChild,
							),
						).$n("mid").className,
				)(),
			),
		)
		.contains(ztl.normalizeText("z-calendar-body"), "");
});
