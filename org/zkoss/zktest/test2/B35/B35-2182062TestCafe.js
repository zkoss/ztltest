import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2182062TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2182062TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
        The two inner tabbox should not have scroll button
        <tabbox width="400px" height="200px">
          <tabs>
            <tab label="Tab 1 test long text"/>
            <tab label="Tab 2 test long text"/>
            <tab label="Tab 2 test long text"/>
            <tab label="Tab 2 test long text"/>
            <tab label="Tab 2 test long text"/>
            <tab label="Tab 3 test long text"/>
            <tab label="Tab 4 test long text"/>
          </tabs>
          <tabpanels>
            <tabpanel>
              <tabbox width="200px">
                <tabs>
                  <tab label="Tab 1"/>
                  <tab label="Tab 2"/>
                </tabs>
                <tabpanels>
                  <tabpanel>
                    This is panel
                            1
                  </tabpanel>
                  <tabpanel>
                    This is panel 2 The
                            second panel
                  </tabpanel>
                </tabpanels>
              </tabbox>
              <tabbox width="200px" tabscroll="false">
                <tabs>
                  <tab label="Tab 1"/>
                  <tab label="Tab 2"/>
                </tabs>
                <tabpanels>
                  <tabpanel>
                    This is panel
                            1
                  </tabpanel>
                  <tabpanel>
                    This is panel 2 The
                            second panel
                  </tabpanel>
                </tabpanels>
              </tabbox>
            </tabpanel>
            <tabpanel>
              This is panel 2 The second panel
            </tabpanel>
            <tabpanel>
              This is panel 3
            </tabpanel>
            <tabpanel>
              This is panel 4
            </tabpanel>
          </tabpanels>
        </tabbox>
      </window>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(zk.Widget.$(jq("@tabbox")).$n("right")).length,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 1)
		.ok("There should be only one scrolled tabbox");
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(zk.Widget.$(jq("@tabbox")).$n("left")).length,
	)();
	await t
		.expect(verifyVariable_cafe_1_1 == 1)
		.ok("There should be only one scrolled tabbox");
});
