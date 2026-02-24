import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-488TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-488TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<html><![CDATA[
				<ol>
				<li>Drag listitem from left to right</li>
				<li>Drag listitem from right to left</li>
				<li>The bug is fixed if do above without any problem.</li>
				</ol>
				]]></html>
				<hbox>
					<listbox id="lb1" droppable="true" width="100px" height="150px">
						<attribute name="onDrop">
							event.getDragged().setParent(self);
							tb.setValue(event.getDragged().getId() + " in " + self.getId());
						</attribute>
						<listitem id="li1" draggable="true">
							<listcell label="list cell 1">
								<div>div</div>
							</listcell>
						</listitem>
					</listbox>
					<separator spacing="20px" />
					<listbox id="lb2" droppable="true" width="100px" height="150px">
						<attribute name="onDrop">
							event.getDragged().setParent(self);
							tb.setValue(event.getDragged().getId() + " in " + self.getId());
						</attribute>
						<listitem id="li2" draggable="true">
							<listcell label="list cell 2">
								<div>div</div>
							</listcell>
						</listitem>
					</listbox>
				</hbox>
				<textbox id="tb" />
			</zk>`,
	);
	await t.dragToElement(
		Selector(() => zk.Desktop._dt.$f("li1", true).$n()),
		Selector(() => zk.Desktop._dt.$f("lb2", true).$n()),
		{
			offsetX: 5,
			offsetY: 5,
			destinationOffsetX: 25,
			destinationOffsetY: 25,
		},
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("tb", true).$n().value,
				)(),
			),
		)
		.eql(ztl.normalizeText("li1 in lb2"));
	await t.dragToElement(
		Selector(() => zk.Desktop._dt.$f("li2", true).$n()),
		Selector(() => zk.Desktop._dt.$f("lb1", true).$n()),
		{
			offsetX: 5,
			offsetY: 5,
			destinationOffsetX: 25,
			destinationOffsetY: 25,
		},
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("tb", true).$n().value,
				)(),
			),
		)
		.eql(ztl.normalizeText("li2 in lb1"));
});
