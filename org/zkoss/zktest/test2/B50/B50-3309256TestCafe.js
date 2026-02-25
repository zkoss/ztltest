import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3309256TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3309256TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			If the text of the input element contains single quote (\'), that is a bug.
			<datebox id="dbx" format="long" locale="zh_TW" width="140px" onCreate="self.value = new Date()"/>
			<timebox id="tbx" format="long" locale="zh_TW" width="140px" onCreate="self.value = new Date()"/>
			</zk>`,
	);
	await t
		.expect(ztl.normalizeText(""))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("dbx", true).$n("real").value,
				)(),
			),
			"the text of the input element should be ready (length >= 8",
		);
	await t
		.expect(ztl.normalizeText(""))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("tbx", true).$n("real").value,
				)(),
			),
			"the text of the input element should be ready (length >= 8",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("dbx", true).$n("real").value,
				)(),
			),
		)
		.notContains(
			ztl.normalizeText("'"),
			"If the text of the input element should not contains single quote (')",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("tbx", true).$n("real").value,
				)(),
			),
		)
		.notContains(
			ztl.normalizeText("'"),
			"If the text of the input element should not contains single quote (')",
		);
});
