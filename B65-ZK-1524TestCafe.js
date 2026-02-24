import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1524TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1524TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
        <label multiline="true">
          Issue : use caption in window will cause hflex="min" doesn\'t work.
	1. Width of "Title" window and "Caption" window should be the same.
	2. Check groupbox and panel also.
        </label>
        <window title="Title" border="normal" hflex="min">
          <div width="200px" height="50px"/>
        </window>
        <window border="normal" hflex="min">
          <caption label="Caption"/>
          <div width="200px" height="50px"/>
        </window>
        <separator/>
        <groupbox title="Title" hflex="min" mold="3d">
          <div width="200px" height="50px"/>
        </groupbox>
        <groupbox hflex="min" mold="3d">
          <caption label="Caption"/>
          <div width="200px" height="50px"/>
        </groupbox>
        <separator/>
        <panel title="Title" border="normal" hflex="min">
          <panelchildren>
            <div width="200px" height="50px"/>
          </panelchildren>
        </panel>
        <panel border="normal" hflex="min">
          <caption label="Caption"/>
          <panelchildren>
            <div width="200px" height="50px"/>
          </panelchildren>
        </panel>
      </zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-window-embedded").find(":contains(Caption)").width(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-window-embedded").find(":contains(Title)").width(),
				)(),
			),
			"Width of 'Title' window and 'Caption' container should be the same.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-groupbox-3d").find(":contains(Caption)").width(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-groupbox-3d").find(":contains(Title)").width(),
				)(),
			),
			"Width of 'Title' window and 'Caption' container should be the same.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-panel").find(":contains(Caption)").width(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-panel").find(":contains(Title)").width(),
				)(),
			),
			"Width of 'Title' window and 'Caption' container should be the same.",
		);
});
