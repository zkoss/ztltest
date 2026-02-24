import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2074948TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2074948TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Menu Demo" border="normal">
        <label value="Vertical Menu Popup position shall be correct"/>
        <window>
          <menubar orient="vertical">
            <menu id="menu" label="12321434564212347897413135498794123154678454674899765131549789451374897942134897">
              <menupopup>
                <menuitem label="1"/>
              </menupopup>
            </menu>
            <menu label="1">
              <menupopup>
                <menuitem label="1"/>
              </menupopup>
            </menu>
            <menu label="href">
              <menupopup>
                <menu label="popup">
                  <menupopup>
                    <menuitem label="item" checkmark="true">
                    </menuitem>
                  </menupopup>
                </menu>
                <menuitem label="checked" autocheck="true" checked="true"/>
                <menuitem label="unchecked, disabled" autocheck="true" checked="false" disabled="true"/>
                <menuitem label="checked, disable" autocheck="true" checked="true" disabled="true"/>
              </menupopup>
            </menu>
          </menubar>
        </window>
      </window>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("menu", true).$n()));
	await ztl.waitResponse(t);
	let xMenu_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("menu", true)).offset().left,
	)();
	let yMenu_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("menu", true)).offset().top,
	)();
	let xPopup_cafe = await ClientFunction(
		() => jq(jq(".z-menupopup")).offset().left,
	)();
	let yPopup_cafe = await ClientFunction(
		() => jq(jq(".z-menupopup")).offset().top,
	)();
	await t
		.expect(xPopup_cafe > xMenu_cafe)
		.ok("The popup must be at right and below of the menu item");
	let result_cafe_0 = await ClientFunction(() => Math.abs(0 - 0) <= 1)();
	let result_cafe = await ClientFunction(
		() => eval("Math.abs(" + yPopup_cafe + "-" + yMenu_cafe + ") <= 1"),
		{ dependencies: { yPopup_cafe, yMenu_cafe } },
	)();
	await t
		.expect(result_cafe)
		.ok("The popup must be at right and below of the menu item");
});
