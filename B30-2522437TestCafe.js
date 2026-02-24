import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2522437TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2522437TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<borderlayout>
        <center>
          <div>
            <button label=\'Click Me\' onClick=\'self.desktop.invalidate()\'/>
            and you shall see this page remains the same
          </div>
        </center>
      </borderlayout>`,
	);
	let contentBefore_cafe = await ClientFunction(() =>
		jq("body").text().replace(/\s/g, " "),
	)();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let contentAfter_cafe = await ClientFunction(() =>
		jq("body").text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(contentAfter_cafe))
		.eql(
			ztl.normalizeText(contentBefore_cafe),
			"The html content should not be changed",
		);
});
