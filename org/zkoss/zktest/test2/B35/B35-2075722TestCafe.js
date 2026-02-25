import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2075722TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2075722TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Grid with Group feature" border="normal">
        <html><![CDATA[
Test Drag-Drop on each panel(The following steps should be true.)<br/>
1.Click the first button, and test the drag-drop on each panel (Please hover mouse over the title of the panel)<br/>
2.Click the second button, and test the drag-drop on each panel (Please hover mouse over the title of the panel)<br/>
3.Click the third button, and test the drag-drop on each panel (Please hover mouse over the title of the panel)<br/>
]]></html>
        <zscript>
          <![CDATA[//@IMPORT
import org.zkoss.zkmax.zul.*;
]]>
          <![CDATA[//@DECLARATION
Portalchildren pc1;
Portalchildren pc2;
List panels = new ArrayList();
void addPortalChidren(){
pc1 = new Portalchildren();
pc2 = new Portalchildren();
pc1.setWidth("60%");
pc2.setWidth("40%");
pc1.setParent(pl);
pc2.setParent(pl);
}

void addPaneltoprotal(Portalchildren pc){
	newPanel(pc);
	newPanel(pc);
	newPanel(pc);
}

void include(Component parent,String name){
}

int count=1;
Panelchildren newPanel(Component parent){
Panel panel = new Panel();
panel.setTitle("panel"+count++);
panel.setHeight("50px");
Panelchildren pc = new Panelchildren();
pc.setParent(panel);
panel.setParent(parent);
panels.add(panel);
return pc;
}
void moveLastPanel(){
if(panels.size()>0){
Panel panel = (Panel)panels.get(panels.size()-1);
if(panel.getParent()==pc1){
panel.setParent(pc2);
}else{
panel.setParent(pc1);
}
}
}

void removeLastPanel(){
if(panels.size()>0){
panels.get(panels.size()-1).detach();
panels.remove(panels.size()-1);
}
}
]]>
          <![CDATA[

]]>
        </zscript>
        <div>
          <button label="1.Add Panels" onClick="addPaneltoprotal(pc1)"/>
          <button label="2.Add Panels" onClick="addPaneltoprotal(pc2)"/>
          <button label="3.move Panel" onClick="moveLastPanel()"/>
          <portallayout id="pl" onCreate="addPortalChidren();">
          </portallayout>
        </div>
      </window>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.hover(Selector(() => jq(".z-panel-header")[0]));
	await ztl.waitResponse(t);
	await t.dragToElement(
		Selector(() => jq(".z-panel-header:contains(panel3)")[0]),
		Selector(() => jq(".z-panel-header:contains(panel1)")[0]),
		{
			offsetX: 2,
			offsetY: 2,
			destinationOffsetX: 0,
			destinationOffsetY: 0,
		},
	);
	await ztl.waitResponse(t);
	await t.expect("false").ok("The panel 1 should be below the panel 3");
	await t.dragToElement(
		Selector(() => jq(".z-panel-header:contains(panel2)")[0]),
		Selector(() => jq(".z-panel-header:contains(panel3)")[0]),
		{
			offsetX: 2,
			offsetY: 2,
			destinationOffsetX: 0,
			destinationOffsetY: 0,
		},
	);
	await ztl.waitResponse(t);
	await t.expect("false").ok("The panel 3 should be below the panel 2");
	await t.dragToElement(
		Selector(() => jq(".z-panel-header:contains(panel1)")[0]),
		Selector(() => jq(".z-panel-header:contains(panel2)")[0]),
		{
			offsetX: 2,
			offsetY: 2,
			destinationOffsetX: 0,
			destinationOffsetY: 0,
		},
	);
	await ztl.waitResponse(t);
	await t.expect("false").ok("The panel 2 should be below the panel 1");
	await t.click(Selector(() => jq("@button")[1]));
	await ztl.waitResponse(t);
	await t.dragToElement(
		Selector(() => jq(".z-panel-header:contains(panel6)")[0]),
		Selector(() => jq(".z-panel-header:contains(panel4)")[0]),
		{
			offsetX: 2,
			offsetY: 2,
			destinationOffsetX: 0,
			destinationOffsetY: 0,
		},
	);
	await ztl.waitResponse(t);
	await t.expect("false").ok("The panel 4 should be below the panel 6");
	await t.dragToElement(
		Selector(() => jq(".z-panel-header:contains(panel5)")[0]),
		Selector(() => jq(".z-panel-header:contains(panel6)")[0]),
		{
			offsetX: 2,
			offsetY: 2,
			destinationOffsetX: 0,
			destinationOffsetY: 0,
		},
	);
	await ztl.waitResponse(t);
	await t.expect("false").ok("The panel 6 should be below the panel 5");
	await t.dragToElement(
		Selector(() => jq(".z-panel-header:contains(panel4)")[0]),
		Selector(() => jq(".z-panel-header:contains(panel5)")[0]),
		{
			offsetX: 2,
			offsetY: 2,
			destinationOffsetX: 0,
			destinationOffsetY: 0,
		},
	);
	await ztl.waitResponse(t);
	await t.expect("false").ok("The panel 5 should be below the panel 4");
	await t.click(Selector(() => jq("@button")[2]));
	await ztl.waitResponse(t);
	await t.dragToElement(
		Selector(() => jq(".z-panel-header:contains(panel6)")[0]),
		Selector(() => jq(".z-panel-header:contains(panel3)")[0]),
		{
			offsetX: 2,
			offsetY: 2,
			destinationOffsetX: 0,
			destinationOffsetY: 0,
		},
	);
	await ztl.waitResponse(t);
	await t.dragToElement(
		Selector(() => jq(".z-panel-header:contains(panel6)")[0]),
		Selector(() => jq(".z-panel-header:contains(panel1)")[0]),
		{
			offsetX: 2,
			offsetY: 2,
			destinationOffsetX: 0,
			destinationOffsetY: 0,
		},
	);
	await ztl.waitResponse(t);
	await t.expect("false").ok("The panel 1 should be below the panel 6");
	await t.dragToElement(
		Selector(() => jq(".z-panel-header:contains(panel1)")[0]),
		Selector(() => jq(".z-panel-header:contains(panel6)")[0]),
		{
			offsetX: 2,
			offsetY: 2,
			destinationOffsetX: 0,
			destinationOffsetY: 0,
		},
	);
	await ztl.waitResponse(t);
	await t.expect("false").ok("The panel 6 should be below the panel 1");
});
