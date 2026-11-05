import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
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
	const rows = Selector(".z-row").addCustomDOMProperties({
		height: (el) => el.getBoundingClientRect().height,
	});
	const unsizedRowHeight = await rows.nth(2).height;
	await t
		.expect(rows.nth(0).height)
		.within(
			Math.max(50, unsizedRowHeight - 1),
			Math.max(50, unsizedRowHeight),
			"a row with height 50px should be 50px tall, or as tall as a row without a height if that is taller",
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
		.expect(rows.nth(1).height)
		.eql(100, "a row with height 100px should be 100px tall");
	await t
		.expect(ztl.normalizeText("101"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@row").eq(1).outerHeight())(),
			),
			"",
		);
});
