import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2107675TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2107675TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	You shall see "Correct 4 Correct 3" below
	<separator bar="true"/>
	<zk switch="\${each}" forEach="zk, gwt">
		<zk case="gwt">
	    Correct 3
		</zk>
		<zk case="\${each}" forEach="best, zk">
	    Correct 4
		</zk>
		<zk>
	    Error 3
		</zk>
	</zk>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@label:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Correct 4"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@label:eq(2)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Correct 3"), "");
});
