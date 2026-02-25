import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3292545TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3292545TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:w="client">
	<html><![CDATA[
		<ol>
			<li>Check all of number are the same.</li>
			<li>Except latest five elements, they will less 2px.</li>
		</ol>
	]]></html>
	<zscript><![CDATA[
		import org.zkoss.zul.*;
		void doInit(Component comp) {
			Div div = new Div();
			div.setHflex("1");
			div.appendChild(new Label("0"));
			div.setWidgetListener("onBind", "this.firstChild.setValue(jq(this).width());");
			comp.appendChild(div);
		}
	]]></zscript>
	<vlayout>
		<hlayout onCreate="doInit(self);"><combobox mold="rounded" width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><bandbox width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><datebox width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><spinner width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><timebox width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><doublespinner  mold="rounded" width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><textbox width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><decimalbox width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><intbox width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><doublebox width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><longbox width="300px" mold="rounded"/></hlayout>
		<hlayout onCreate="doInit(self);"><combobox width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><bandbox width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><datebox width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><spinner width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><timebox width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><doublespinner  width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><textbox width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><decimalbox width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><intbox width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><doublebox width="300px"/></hlayout>
		<hlayout onCreate="doInit(self);"><longbox width="300px"/></hlayout>
	</vlayout>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@combobox:eq(0)").outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@bandbox:eq(0)").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@datebox:eq(0)").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@spinner:eq(0)").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@timebox:eq(0)").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@doublespinner:eq(0)").outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@textbox:eq(0)").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@decimalbox:eq(0)").outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@intbox:eq(0)").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@doublebox:eq(0)").outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@longbox:eq(0)").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@combobox:eq(1)").outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@bandbox:eq(1)").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@datebox:eq(1)").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@spinner:eq(1)").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@timebox:eq(1)").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@doublespinner:eq(1)").outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("300"));
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("300"),
		ztl.normalizeText(
			await ClientFunction(() => jq("@textbox:eq(1)").outerWidth())(),
		),
		ztl.normalizeText("2"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("300"),
		ztl.normalizeText(
			await ClientFunction(() => jq("@decimalbox:eq(1)").outerWidth())(),
		),
		ztl.normalizeText("2"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("300"),
		ztl.normalizeText(
			await ClientFunction(() => jq("@intbox:eq(1)").outerWidth())(),
		),
		ztl.normalizeText("2"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("300"),
		ztl.normalizeText(
			await ClientFunction(() => jq("@doublebox:eq(1)").outerWidth())(),
		),
		ztl.normalizeText("2"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("300"),
		ztl.normalizeText(
			await ClientFunction(() => jq("@longbox:eq(1)").outerWidth())(),
		),
		ztl.normalizeText("2"),
	);
});
