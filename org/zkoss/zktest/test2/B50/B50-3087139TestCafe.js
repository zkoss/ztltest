import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3087139TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3087139TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
It is correct if you see no JavaScript error, and OK to select items.
<listbox id="lb" mold="select">
	<listitem>
		<listcell label="abc">
		<textbox/>
		</listcell>
	</listitem>
</listbox>
</zk>`,
	);
	await t
		.click(Selector(() => jq(zk.Desktop._dt.$f("lb", true))[0]))
		.click(
			Selector(
				() =>
					jq(zk.Desktop._dt.$f("lb", true)).find(
						"option:contains(abc)",
					)[0],
			),
		);
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
