import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1829397TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1829397TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Test of on-shot timer" xmlns:html="http://www.w3.org/1999/xhtml">
        <vbox id="v">
          You shall see only one label below:
          <timer delay="1000" repeats="false">
            <attribute name="onTimer">
              v.appendChild(new Label("You shall see this label only once!!! running:"+self.running));
            </attribute>
          </timer>
        </vbox>
      </window>`,
	);
	await t.expect(await ClientFunction(() => jq("$v").is(":visible"))()).ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label").eq(0).text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("You shall see only one label below:"), "");
	await t.wait(1100);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label").eq(1).text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(
			ztl.normalizeText("You shall see this label only once!!!"),
			"",
		);
});
