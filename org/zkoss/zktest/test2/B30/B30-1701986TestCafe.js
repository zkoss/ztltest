import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1701986TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1701986TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="constraints depends on two component" border="normal">
				Bug 1701986: The error msgbox should disappear when error is corrected.
				<zscript>
					<![CDATA[
			Constraint ctt = new Constraint() {
				public void validate(Component comp, Object value)
						throws WrongValueException {		
						comp.setAttribute("dt", value);
						if (comp.getFellowIfAny("endDate") != null
								&& comp.getFellowIfAny("beginDate") != null) {
							Date beginValue = null;
							if (comp.getId().equals("beginDate")) {
								beginValue = (Date) value;
							} else {
								beginValue = (Date) ((Datebox) comp.getFellowIfAny("beginDate")).getAttribute("dt");
							}
							Date endValue = null;
							if (comp.getId().equals("endDate")) {
								endValue = (Date) value;
							} else {					
								endValue = (Date)((Datebox) comp.getFellowIfAny("endDate")).getAttribute("dt");
							}
							if (beginValue != null && endValue != null) {
								if (endValue.before(beginValue)) {
									throw new WrongValueException(comp, "ErrorMessage");
								} else {					
									long startM = beginValue.getTime();
									long endM = endValue.getTime();
									int days_plan = ((Long) ((endM - startM) / 1000 / 60 / 60 / 24))
											;
									((Label) comp.getFellowIfAny("days"))
											.setValue(new Integer(days_plan).toString());
									comp.getFellow("beginDate").clearErrorMessage();
									comp.getFellow("endDate").clearErrorMessage();
								}
							}
						}
				}
			};
			]]>
				</zscript>
				<grid width="90%">
					<rows>
						<row>			
							<label id="days" />
						</row>
						<row>
							start date box:
							<datebox id="beginDate" constraint="\${ctt}"/>
						</row>
						<row>
							end date box:
							<datebox id="endDate" constraint="\${ctt}" />
						</row>
					</rows>
				</grid>
				<label id = "lb" />
			<button id="submit" label="submit">
			<attribute name="onClick">
			lb.setValue((beginDate.getValue() == null ? "" : beginDate.getValue().toString())
			+(endDate.getValue() == null ? "" : endDate.getValue().toString()) );
			</attribute>
			</button>
			</window>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq("$beginDate")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-datebox:eq(0)")).$n("pp")).css(
						"display",
					),
				)(),
			),
		)
		.notEql(ztl.normalizeText("none"), "");
	await t.click(Selector(() => jq(".z-calendar-weekday:eq(19)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq("$endDate")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-datebox:eq(1)")).$n("pp")).css(
						"display",
					),
				)(),
			),
		)
		.notEql(ztl.normalizeText("none"), "");
	await t.click(
		Selector(
			() =>
				jq(zk.Widget.$(jq(".z-datebox:eq(1)")).$n("pp")).find(
					".z-calendar-weekday:eq(14)",
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$submit")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
});
