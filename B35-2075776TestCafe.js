import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2075776TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2075776TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Column\'s Menu Demo" border="normal" width="500px">
        1. Please click the "remove column1" or "remove column2" button.
        <separator/>
        2. Mouse-over the header of the grid. And then click on the menu icon of the header.
        <separator/>
        3. You should see the menu popup, that is correct.
        <grid id="gd">
          <columns sizable="true" menupopup="auto" id="cols">
            <column id="col" label="Type" sortAscending="&#36;{asc}" sortDescending="&#36;{dsc}"/>
            <column id="col1" label="Type1" sortAscending="&#36;{asc}" sortDescending="&#36;{dsc}"/>
            <column id="col2" label="Content"/>
          </columns>
          <rows id="rs">
            <row id="r1">
              <label value="File:" id="lb1"/>
              <label value="File1:"/>
              <textbox width="98%" id="tb1"/>
            </row>
            <row id="r2">
              <label value="File:" id="lb2"/>
              <label value="File1:"/>
              <textbox width="98%" id="tb2"/>
            </row>
            <row id="r3">
              <label value="Files:" id="lb3"/>
              <label value="File1s:"/>
              <textbox width="98%" id="tb3"/>
            </row>
          </rows>
        </grid>
        <button label="remove column1">
          <attribute name="onClick">
            cols.removeChild(col);
r1.removeChild(lb1);
r2.removeChild(lb2);
r3.removeChild(lb3);
          </attribute>
        </button>
        <button label="remove column2">
          <attribute name="onClick">
            cols.removeChild(col1);
r1.removeChild(tb1);
r2.removeChild(tb2);
r3.removeChild(tb3);
          </attribute>
        </button>
      </window>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.hover(Selector(() => jq(zk.Desktop._dt.$f("col1", true))[0]));
	await ztl.waitResponse(t);
	await t.hover(
		Selector(() => jq(zk.Desktop._dt.$f("col1", true).$n("btn"))[0]),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(zk.Desktop._dt.$f("col1", true).$n("btn"))[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-menupopup")[0])())
		.ok("The menu popup should be visible");
});
