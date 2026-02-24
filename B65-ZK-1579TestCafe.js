import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1579TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1579TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
        <label multiline="true">
          1. Click "toggle" button.
		2. See "Listbox B" showed.
		3. Click "toggle" button again.
		4. Should see "Listbox A" resized to match hflex="1".
        </label>
        <window title="Window1" border="normal" id="win" width="500px">
          <hlayout hflex="1" vflex="min">
            <vlayout hflex="1" vflex="min">
              <label value="Listbox A"/>
              <listbox hflex="1">
                <listitem label="A1"/>
                <listitem label="A2"/>
              </listbox>
            </vlayout>
            <vlayout hflex="1" vflex="min" id="d" visible="false">
              <label value="Listbox B"/>
              <listbox hflex="1">
                <listitem label="B1"/>
                <listitem label="B2"/>
              </listbox>
            </vlayout>
          </hlayout>
          <button label="toggle" onClick="d.visible = !d.visible;"/>
        </window>
      </zk>`,
	);
	let wd0_cafe = await ClientFunction(() =>
		jq(".z-window-embedded").find(".z-hlayout-inner").width(),
	)();
	await t.click(Selector(() => jq(".z-button:contains(toggle)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(".z-window-embedded").find(
						".z-label:contains(Listbox B)",
					)[0],
			)(),
		)
		.ok("See 'Listbox B' showed.");
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-window-embedded").find(".z-listbox")[0],
			)(),
		)
		.ok("See 'Listbox B' showed.");
	await t.click(Selector(() => jq(".z-button:contains(toggle)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-window-embedded").find(".z-hlayout-inner").width(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(wd0_cafe),
			"Should see 'Listbox A' resized to match hflex='1'.",
		);
});
