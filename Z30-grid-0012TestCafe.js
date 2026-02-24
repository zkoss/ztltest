import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z30-grid-0012TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z30-grid-0012TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="test row height">
				<grid width="400px">
					<rows>
						<row height="50px">1, height = 50px</row>
						<row height="100px">2, height = 100px</row>
						<row>3</row>
						<row>4</row>
						<row>5</row>
						<row>6</row>
						<row>7</row>
						<row>8</row>
						<row>9</row>
						<row>10</row>
					</rows>
				</grid>
			</window>`,
	);
	await t
		.expect(ztl.normalizeText("50"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@row").eq(0).outerHeight())(),
			),
		);
	await t
		.expect(ztl.normalizeText("51"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@row").eq(0).outerHeight())(),
			),
			"",
		);
	await t
		.expect(ztl.normalizeText("100"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@row").eq(1).outerHeight())(),
			),
		);
	await t
		.expect(ztl.normalizeText("101"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@row").eq(1).outerHeight())(),
			),
			"",
		);
});
