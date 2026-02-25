import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2075716TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2075716TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
        1. Press the "add" button, and see the new column of Portallayout is 50% of right remainder width.
        <separator/>
        2. Press the "remove" button, and see the column disappear.
        <separator/>
        3. If no any error, that is true.
        <button label="add" onClick="add()"/>
        <button label="remove" onClick="remove()"/>
        <portallayout id="cl">
          <portalchildren width="200px" style="padding: 5px">
            <panel height="100px" title="portal" border="normal" maximizable="true" collapsible="true">
              <panelchildren>Panel</panelchildren>
            </panel>
          </portalchildren>
        </portallayout>
        <zscript>
          <![CDATA[
	import org.zkoss.zkmax.zul.Portalchildren;
	import org.zkoss.zul.Spinner;
	
	Portalchildren[] cc = new Portalchildren[15];
	int count = 0;
	
	public void add() {
		if (count > 14) return;
		
		cc[count] = new Portalchildren();
		cc[count].setWidth("50%");
		cc[count].setParent(cl);
		
		Panel p = new Panel();
		p.setHeight("100px");
		p.setStyle("padding: 5px");
		p.setTitle("portal " + count);
		p.setBorder("normal");
		
		
		Panelchildren pc = new Panelchildren();
		Label l = new Label("test");
		l.setParent(pc);
		pc.setParent(p);
		p.setParent(cc[count]);
		count++;
	}
	public void remove() {
		if (count > 0)
			cc[--count].detach();
	}
]]>
        </zscript>
      </window>`,
	);
	let total_width_cafe = await ClientFunction(() =>
		jq(".z-portallayout").width(),
	)();
	let panel0_width_cafe = await ClientFunction(() =>
		jq(".z-portalchildren").width(),
	)();
	await t.click(Selector(() => jq("@button:contains(add)")[0]));
	await ztl.waitResponse(t);
	let new_panel_width_cafe = await ClientFunction(() =>
		jq(".z-portalchildren:contains(portal 0)").width(),
	)();
	let remainder_width_cafe = total_width_cafe - panel0_width_cafe - 10;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(remainder_width_cafe / 2),
		ztl.normalizeText(new_panel_width_cafe),
		ztl.normalizeText("2"),
	);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
