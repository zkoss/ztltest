import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-956TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-956TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<h:pre xmlns:h="html">
					Click the button and it shouldn\'t show up Exception message.
				</h:pre>
				<zscript>
					public void addLabelAndTooltip (Component comp) {
						Div container = new Div(); // dettached, imagine we DON\'T have parent component at this point, e.g. macro component is being constructed
						Popup tooltip = new Popup();
						Label tooltiptext = new Label(" this is tool tip");
						tooltiptext.setParent(tooltip);
						Label label = new Label();
						label.setValue(" new label");
						label.setTooltip(tooltip); // tooltip is still dettached; anonymous UUID is used as tooltip ref
						label.setParent(container);
						tooltip.setParent(container);
						container.setParent(comp); // everything is attached; tooltip gets normal UUID; label still uses anonymous UUID as tooltip ref
						
						Popup tooltip2 = new Popup();
						Label tooltiptext2 = new Label(" this is tool tip 2");
						tooltiptext2.setParent(tooltip2);
						tooltip2.setParent(comp);
						Label l = new Label();
						l.setValue(" new label 2");
						l.setTooltip(tooltip2);
						l.setParent(comp);
					}
				</zscript>
				<window id="win" title="test win" border="normal" width="200px" height="200px"  />
					 
			    <button id="btn" label="tset" onClick="addLabelAndTooltip(win);" />
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("No exception");
});
