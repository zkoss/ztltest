import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3626TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3626.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3626TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		document.body.style.zoom = "1.5";
	})();
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(".z-menubar-right").click();
	})();
	await ClientFunction(() => {
		jq(".z-tabbox-right-scroll").click();
	})();
	await ClientFunction(() => {
		jq(".z-tabbox-down-scroll").click();
	})();
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(".z-menubar-right").click();
	})();
	await ClientFunction(() => {
		jq(".z-tabbox-right-scroll").click();
	})();
	await ClientFunction(() => {
		jq(".z-tabbox-down-scroll").click();
	})();
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(".z-menubar-right").click();
	})();
	await ClientFunction(() => {
		jq(".z-tabbox-right-scroll").click();
	})();
	await ClientFunction(() => {
		jq(".z-tabbox-down-scroll").click();
	})();
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(".z-menubar-right").click();
	})();
	await ClientFunction(() => {
		jq(".z-tabbox-right-scroll").click();
	})();
	await ClientFunction(() => {
		jq(".z-tabbox-down-scroll").click();
	})();
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(".z-menubar-right").click();
	})();
	await ClientFunction(() => {
		jq(".z-tabbox-right-scroll").click();
	})();
	await ClientFunction(() => {
		jq(".z-tabbox-down-scroll").click();
	})();
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(".z-menubar-right").click();
	})();
	await ClientFunction(() => {
		jq(".z-tabbox-right-scroll").click();
	})();
	await ClientFunction(() => {
		jq(".z-tabbox-down-scroll").click();
	})();
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(".z-menubar-right").click();
	})();
	await ClientFunction(() => {
		jq(".z-tabbox-right-scroll").click();
	})();
	await ClientFunction(() => {
		jq(".z-tabbox-down-scroll").click();
	})();
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(".z-menubar-right").click();
	})();
	await ClientFunction(() => {
		jq(".z-tabbox-right-scroll").click();
	})();
	await ClientFunction(() => {
		jq(".z-tabbox-down-scroll").click();
	})();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("true,true,true"));
	await ClientFunction(() => {
		document.body.style.zoom = "1";
	})();
});
