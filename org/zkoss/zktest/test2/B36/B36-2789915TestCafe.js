import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2789915TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2789915TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			Please press upon the MSN icon to reset the hoverIamge, and then move the mouse out the button, you should see a defender image.
			<toolbar width="200px" id="tb" sclass="vista" height="20px"
			align="end">
			<toolbarbutton id="toolbarbutton1" image="/img/live.gif"
			disabled="false" hoverImage="/img/network.gif"
			
			onClick=\'toolbarbutton1.setDisabled(!toolbarbutton1.isDisabled());
			if (toolbarbutton1.isDisabled()) {
			
			toolbarbutton1.setImage("/img/defender.gif");
			
			toolbarbutton1.setHoverImage(null);
			} else {
			
			toolbarbutton1.setImage("/img/live.gif");
			}\' />
			</toolbar>
      <label id="l1"> out </label>
			</zk>`,
	);
	await t.hover(
		Selector(() => zk.Desktop._dt.$f("toolbarbutton1", true).$n()),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("toolbarbutton1", true).$n()),
	);
	await ztl.waitResponse(t);
	await t.hover(Selector(() => jq("$l1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("toolbarbutton1", true))
						.find("img")
						.attr("src"),
				)(),
			),
		)
		.contains(ztl.normalizeText("defender"), "");
});
