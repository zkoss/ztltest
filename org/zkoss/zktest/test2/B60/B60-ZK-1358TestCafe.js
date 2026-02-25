import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1358TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1358TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:h="native">
                    <label multiline="true" style="font-size: 14px">
                      1. If not see Modal Window, it is a bug.
	2. Click \'popup\' button, should see Popup.
                    </label>
                    <window vflex="1" hflex="1" border="none" position="center" mode="modal">
                      <div style="background-color:gold;" width="437px" height="341px">
                        Modal Window
                        <button id="btn" label="popup" onClick=\'pp.open(self, "after_end");\'/>
                        <popup vflex="1" hflex="1" id="pp">
                          <div style="background-color: pink;" width="200px" height="100px">Popup</div>
                        </popup>
                      </div>
                    </window>
                  </zk>`,
	);
	await t
		.expect(ztl.normalizeText("block"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-window-modal").css("display"),
				)(),
			),
		);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("visible"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-popup").css("visibility"))(),
			),
		);
});
