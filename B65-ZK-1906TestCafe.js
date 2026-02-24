import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1906TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1906TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1906.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Sep 02, 2013  5:53:36 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
1. Please select some items in the chosenbox
<separator/>
2. Click the button and it shouldn\'t appear with "[]" text.
<separator/>
	<zscript><![CDATA[
	import org.zkoss.zul.ItemRenderer;
   	public class Bean {
   		String _name;
   		public Bean(String name) {
   			_name = name;
   		}
   		
   		public String getName() {
   			return _name;
   		}
   	}
	List lst = Arrays.asList(new Bean[] { new Bean("first"), new Bean("second"), new Bean("third") });
	
	public class NameRenderer implements ItemRenderer {
		public String render(Component owner, Object data, int index)
				throws Exception {
			Bean b = (Bean) data; 
			return b.getName();
		}
	}
	ItemRenderer nameRenderer = new NameRenderer();
	
	ListModel model = new ListModelList(lst);
	
	public void echo(Set s) {
		if (s.size() == 0) {
			alert(s); 
		} else {
			String msg = "[";
			for (Bean b: s) {
				msg += b.getName() + ",";
			}
			alert(msg + "]");
		}
	}
]]></zscript>
	<chosenbox id="cbx" width="500px" model="\${model}" itemRenderer="\${nameRenderer}"/>
	<button id="btn" label="getSelectedObject()" onClick=\'echo(cbx.getSelectedObjects());\'/>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-chosenbox")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-chosenbox-option")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.notContains(
			ztl.normalizeText("[]"),
			"it shouldn't appear with '[]' text.",
		);
});
