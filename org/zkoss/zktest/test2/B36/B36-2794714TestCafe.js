import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2794714TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2794714TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<html><![CDATA[      
					<ul>		
						<li>Click "HIDE ALL" button</li>
						<li>You sould not see any exception</li>
					</ul>
				]]></html>
				<zscript>
				import java.util.*;
				
				List items = new org.zkoss.zktest.test2.BigList(100);	//a big list of Integer
				</zscript>
				<listbox id="listbox" mold="paging">
					<listitem forEach="&#36;{items}">
						<listcell label="&#36;{each}-1" />
						<listcell label="&#36;{each}-2" />
						<listcell label="&#36;{each}-3" />
						<listcell label="&#36;{each}-4" />
					</listitem>
				</listbox>
				<button id="btn" label="HIDE ALL">
					<attribute name="onClick"><![CDATA[
						import java.util.*;
						for (Component c: listbox.getItems()){
							c.setVisible(false);
						}
						listbox.invalidate();
					new Label("hi").setPage(page);
					]]></attribute>
				</button>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-highlighted")[0])())
		.notOk();
});
