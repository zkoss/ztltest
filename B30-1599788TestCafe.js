import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1599788TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1599788TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>			
			<vbox>
				<grid width="200px">
			 		<columns>
				        <column label="aa"/>
				        <column label="bb"/>
			       </columns>
			       <rows id="serverRows">
			       </rows>
				</grid>
				Rows: <label id="rowNr"/>
			 </vbox>
			<zscript>
			int cnt = 0;
			</zscript>
			<timer id="timer" delay="50" repeats="true" running="false">
					<attribute name ="onTimer">
						serverRows.getChildren().clear();
						Row row = new Row();
						row.setParent(serverRows);
						Label label = new Label();
						label.setParent(row);
						label.setId("l" + ++cnt);
						label.setValue(cnt + "");
						label = new Label();
						label.setParent(row);
						label.setValue("label1_1-"+ cnt);
						row = new Row();
						row.setParent(serverRows);
						Label label = new Label();
						label.setParent(row);
						label.setValue("label2-" + cnt);
						label = new Label();
						label.setParent(row);
						label.setValue("label2_2-" + cnt);
						rowNr.setValue(cnt + "");
					</attribute>
			</timer>
				<button id="stop" label="Stops timer" onClick="timer.stop()"/>
				<button id="start" label="Starts timer" onClick="timer.start()"/>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("start", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("stop", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt
						.$f("serverRows", true)
						.firstChild.firstChild.getValue(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("rowNr", true).getValue(),
				)(),
			),
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("start", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("stop", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt
						.$f("serverRows", true)
						.firstChild.firstChild.getValue(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("rowNr", true).getValue(),
				)(),
			),
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("start", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("stop", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt
						.$f("serverRows", true)
						.firstChild.firstChild.getValue(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("rowNr", true).getValue(),
				)(),
			),
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("start", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("stop", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt
						.$f("serverRows", true)
						.firstChild.firstChild.getValue(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("rowNr", true).getValue(),
				)(),
			),
		);
});
