import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2688197TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2688197TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<html><![CDATA[
				Test 3 Cases:
				<ol>
					<li>In IE 7, the popup have width but no height.</li>
					<li>In all browser, the popup have height but no width.</li>
					<li>In all browser, the popup have no height and no width</li>
				</ol>
				]]></html>
				<vbox>
					<hbox>
						<button label="set width">
							<attribute name="onClick"><![CDATA[
						 title.setWidth("300px");
					]]></attribute>
						</button>
						<button label="no width">
							<attribute name="onClick"><![CDATA[
						title.setWidth("");
					]]></attribute>
						</button>
						<button label="set height">
							<attribute name="onClick"><![CDATA[
						title.setHeight("100px");
					]]></attribute>
						</button>
						<button label="no height">
							<attribute name="onClick"><![CDATA[
						title.setHeight("");
					]]></attribute>
						</button>
					</hbox>
					<label value="Click me to Show Popup!" popup="title" />
				</vbox>
				<popup id="title">
					<html>Input the subject of this letter. Problem report :</html>
					<toolbarbutton label="ZK Forum" target="zkdemo"
						href="http://www.zkoss.org/forum" />
				</popup>

			</zk>`,
	);
	await t.click(Selector(() => jq('@button[label="no width"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('@button[label="set height"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@label")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("title", true).$n())[0].style
							.height,
				)(),
			),
		)
		.eql(ztl.normalizeText("100px"), "have height");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("title", true).$n())[0].style
							.width,
				)(),
			),
		)
		.eql(ztl.normalizeText(""), "have no width");
	await t.click(Selector(() => jq('@button[label="no width"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('@button[label="no height"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@label")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("title", true).$n())[0].style
							.height,
				)(),
			),
		)
		.eql(ztl.normalizeText(""), "have no height");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("title", true).$n())[0].style
							.width,
				)(),
			),
		)
		.eql(ztl.normalizeText(""), "have no width");
});
