import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3057311TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3057311TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
1. Please select "ActionMovies" on the drop down list.
  <listbox id=\'categoryLstBox\' mold="select" rows="1">
  		<attribute name="onSelect">
  		Messagebox.show("Press on either Yes or No is okay, and then focus into the listbox, you shouldn\'t see the dialog again!",
                      "Confirmation Prompt",
                      Messagebox.YES | Messagebox.NO,
                      Messagebox.QUESTION,
                      new org.zkoss.zk.ui.event.EventListener() {
                        public void onEvent(Event evt) throws Exception{
                         categoryLstBox.selectedIndex = 0;
                        }//end onEvent()
                      }//end EventListener instance
                      );
      
  		</attribute>
     <listitem label=\'Cartoons\' value=\'C\' selected=\'true\'/>
     <listitem label=\'ActionMovies\' value=\'A\' />
  </listbox>
  <textbox focus="true"/>
</zk>`,
	);
	await t
		.click(Selector(() => jq(zk.Desktop._dt.$f("categoryLstBox", true))[0]))
		.click(
			Selector(
				() =>
					jq(zk.Desktop._dt.$f("categoryLstBox", true)).find(
						"option:contains(ActionMovies)",
					)[0],
			),
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-window-highlighted @button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq("@textbox").focus();
	})();
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-window-highlighted @button:eq(0)")[0],
			)(),
		)
		.notOk();
});
