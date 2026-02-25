import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-381TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-381TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<html><![CDATA[
				<ol>
				<li>Click right arrow to scroll menubar to right most side.</li>
				<li>Click left arrow to scroll menubar to left most side.</li>
				<li>The bug is fixed if do above without any problem.</li>
				</ol>
				]]></html>
					<menubar id="menubar" width="130px" scrollable="true">
						<menu label="Project" image="/img/Centigrade-Widget-Icons/Briefcase-16x16.png">
							<menupopup>
								<menuitem label="New" onClick="alert(self.label)"  />
								<menuitem label="Open" onClick="alert(self.label)" />
								<menuitem label="Save" onClick="alert(self.label)"  />
								<menuitem label="Exit" onClick="alert(self.label)"  />
							</menupopup>
						</menu>
						<menu label="Help">
							<menupopup>
								<menuitem label="Bug Report" onClick="alert(self.label)"  />
								<menu label="About">
									<menupopup>
										<menuitem label="About Potix"  onClick="alert(self.label)" />
									</menupopup>
								</menu>
							</menupopup>
						</menu>
						<menuitem label="ZK Web Framework" onClick="alert(self.label)" />
					</menubar>
				</zk>`,
	);
	let i_cafe = await ClientFunction(
		() =>
			jq(zk.Desktop._dt.$f("menubar", true).$n("cave")).children().length,
	)();
	let wd1_cafe = parseInt(
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("menubar", true).$n("cave"))[0].firstChild
					.offsetWidth,
		)(),
	);
	let wd2_cafe = parseInt(
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("menubar", true).$n("cave"))[0].firstChild
					.nextSibling.offsetWidth,
		)(),
	);
	let wd3_cafe = parseInt(
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("menubar", true).$n("cave"))[0].firstChild
					.nextSibling.nextSibling.offsetWidth,
		)(),
	);
	await t
		.click(Selector(() => zk.Widget.$(jq(".z-menubar")).$n("right")))
		.wait(500)
		.click(Selector(() => zk.Widget.$(jq(".z-menubar")).$n("right")))
		.wait(500)
		.click(Selector(() => zk.Widget.$(jq(".z-menubar")).$n("right")))
		.wait(500)
		.click(Selector(() => zk.Widget.$(jq(".z-menubar")).$n("right")))
		.wait(500)
		.click(Selector(() => zk.Widget.$(jq(".z-menubar")).$n("right")))
		.wait(500);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("menubar", true).$n("body").scrollLeft,
		)(),
	);
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("menubar", true).$n("body")).outerWidth(),
	)();
	let verifyVariable_cafe_2_2 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("menubar", true).$n("body").scrollLeft,
		)(),
	);
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("menubar", true).$n("body")).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0),
		ztl.normalizeText(
			wd1_cafe + wd2_cafe + wd3_cafe - verifyVariable_cafe_3_3,
		),
		ztl.normalizeText("16"),
	);
	await t
		.click(Selector(() => zk.Widget.$(jq(".z-menubar")).$n("left")))
		.wait(500)
		.click(Selector(() => zk.Widget.$(jq(".z-menubar")).$n("left")))
		.wait(500)
		.click(Selector(() => zk.Widget.$(jq(".z-menubar")).$n("left")))
		.wait(500)
		.click(Selector(() => zk.Widget.$(jq(".z-menubar")).$n("left")))
		.wait(500)
		.click(Selector(() => zk.Widget.$(jq(".z-menubar")).$n("left")))
		.wait(500);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Desktop._dt.$f("menubar", true).$n("body")
							.scrollLeft,
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
});
