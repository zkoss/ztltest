import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2948829TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2948829TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<?taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" ?>
<div>
<html><![CDATA[
Test environment: ZK EE
<ol>
	<li>Click the dropdown button</li>
	<li>Click the icon before "level 1.1" to see if two more items are shown (level 1.1.1 and level 1.1.2)</li>
	<li>Click the "ZK" tab to see if "The second tabpanel" is shown</li>
</ol>
]]></html>

<bandbox>
<bandpopup>
<tree width="100%" style="border:0px;" height="100%">
	<treechildren style="background-image: url(\${c:encodeURL(\'/img/gradient2.jpg\')});">
	 	<treeitem open="true">
		 	<treerow>
			 	<treecell label="Start"
	             			style="color:#15428b; font-weight:bold; font-size:11px" />
			</treerow>
			<treechildren
					style="background-image: url(\${c:encodeURL(\'/img/gradient2.jpg\')});">
				<treeitem open="true">
					<treerow>
						<treecell
							label="level 1"
							style="color:#15428b; font-weight:bold; font-size:11px" />
						</treerow>
						<treechildren
								style="background-image: url(\${c:encodeURL(\'/img/gradient2.jpg\')});">
				 			<treeitem open="false">
								<treerow>
									<treecell
										label="level 1.1"
										style="color:#15428b; font-weight:bold; font-size:11px" />
								</treerow>
									<treechildren>
										<treeitem>
											<treerow>
												<treecell
													label="level 1.1.1"
													style="color:#15428b; font-weight:bold; font-size:11px" />
											</treerow>
										</treeitem>
										<treeitem>
											<treerow>
												<treecell
													label="level 1.1.2"
													style="color:#15428b; font-weight:bold; font-size:11px" />
											</treerow>
										</treeitem>	
									</treechildren>
								</treeitem>
								<treeitem>
									<treerow>
										<treecell
											label="level 1.2"
											style="color:#15428b; font-weight:bold; font-size:11px" />
									</treerow>
									<treechildren>
										<treeitem>
											<treerow>
												<treecell
													label="level 1.2.1"
													style="color:#15428b; font-weight:bold; font-size:11px" />
											</treerow>
										</treeitem>
										<treeitem>
											<treerow>
												<treecell
													label="level 1.2.2"
													style="color:#15428b; font-weight:bold; font-size:11px" />
											</treerow>
										</treeitem>	
									</treechildren>
								</treeitem>
						</treechildren>	
				</treeitem>
			</treechildren>
		</treeitem>
	</treechildren>	
</tree>
<tabbox width="300px">
	<tabs>
		<tab id="tab1" label="AJAX"/>
		<tab id="tab2" label="ZK"/>
	</tabs>
	<tabpanels>
		<tabpanel id="p1">
The first tabpanel
		</tabpanel>
		<tabpanel id="p2">
The second tabpanel
		</tabpanel>
	</tabpanels>
</tabbox>
</bandpopup>
</bandbox>	
						
</div>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq(".z-bandbox")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-treerow:contains(level 1.1)").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(".z-treerow:contains(level 1.1)")).$n("icon"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-treerow:contains(level 1.1)").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-treerow:eq(3)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("level 1.1.1"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-treerow:eq(4)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("level 1.1.2"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-tabpanel").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t.click(Selector(() => zk.Desktop._dt.$f("tab2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-tabpanel").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(".z-tabpanel:eq(0)")).is(":visible"),
			)(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(".z-tabpanel:eq(1)")).is(":visible"),
			)(),
		)
		.ok();
});
