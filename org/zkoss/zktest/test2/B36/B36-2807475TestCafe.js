//@nonConcurrent
import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2807475TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2807475TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios")) {
		console.log("This issue is ignored in current browser! (ios)");
		return;
	}
	await ztl.runZscript(
		t,
		`<zk>
        When you click the menu popup then click the textbox. the textbox\'s focus
event should be triggered in IE.
---
        <hbox>
          <menubar id="menubar" width="200px">
            <menu>
              <menupopup>
                <menuitem label="Index"/>
              </menupopup>
            </menu>
          </menubar>
          <textbox id="demo1" onFocus=\'demo2.value+=1\'/>
          focus count:<intbox id="demo2" value="1"/>
        </hbox>
      </zk>`,
	);
	await t.click(Selector(() => jq("$menubar")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$demo1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq("$demo1:focus")[0])())
		.ok("The textbox should have focus");
	await t
		.expect(
			ztl.normalizeText(await ClientFunction(() => jq("$demo2").val())()),
		)
		.eql(ztl.normalizeText("2"), "The text should be selected");
});
