import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-1202TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1202TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <html>
                      <![CDATA[
  <ol>
  <li>You shall see two comboboxes.</li> 
  <li>The first combobox contains the week type: "Regular Week" and "Working Week".</li>
  <li>The second combobox contains the days indicated by the selection of the first combobox.</li>
  <li>If "Regular Week" is selected in the first combobox, the second combobox should contain "Sunday" through "Saturday".</li>
  <li>If "Working Week" is selected in the first combobox, the second combobox should contain "Monday" through "Friday".</li>
  <li>No exceptions should occur when changing the selection in any order.</li>
  </p>
]]>
                    </html>
                    <borderlayout width="100%" height="100%" apply="org.zkoss.bind.BindComposer" viewModel="@id(\'dw\') \n    @init(\'org.zkoss.zktest.test2.B60_ZK_1202_DaysAndWeeks\')">
                      <center>
                        <grid model="@load(dw.dayWeekModels)" width="550px" emptyMessage="No Index Fields to show">
                          <columns>
                            <column label="Week Type"/>
                            <column label="Days"/>
                          </columns>
                          <rows>
                            <template name="model" var="dayWeekModel">
                              <row>
                                <combobox autocomplete="true" readonly="true" autodrop="true" selectedItem="@bind(dayWeekModel.selectedWeekType)" model="@bind(dayWeekModel.weekTypes)">
                                  <template name="model" var="weekType">
                                    <comboitem label="@load(weekType)"/>
                                  </template>
                                </combobox>
                                <combobox autocomplete="true" readonly="true" model="@bind(dayWeekModel.days)" selectedItem="@load(dayWeekModel.selectedDay)">
                                  <template name="model" var="day">
                                    <comboitem label="@load(day)"/>
                                  </template>
                                </combobox>
                              </row>
                            </template>
                          </rows>
                        </grid>
                      </center>
                    </borderlayout>
                  </zk>`,
	);
	await t
		.expect(ztl.normalizeText("2"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-combobox").length)(),
			),
			"You shall see two comboboxes.",
		);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-combobox:eq(0)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-comboitem:contains(Regular)")[0],
			)(),
		)
		.ok(
			"The first combobox contains the week type: 'Regular Week' and 'Working Week'.",
		);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-comboitem:contains(Working)")[0],
			)(),
		)
		.ok(
			"The first combobox contains the week type: 'Regular Week' and 'Working Week'.",
		);
	await t.click(Selector(() => jq(".z-comboitem:contains(Regular)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk(
			"No exceptions should occur when changing the selection in any order.",
		);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-combobox:eq(1)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("none"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-comboitem:contains(Sunday)").css("display"),
				)(),
			),
			"If 'Regular Week' is selected in the first combobox, the second combobox should contain 'Sunday' through 'Saturday'.",
		);
	await t.click(Selector(() => jq(".z-comboitem:contains(Sunday)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk(
			"No exceptions should occur when changing the selection in any order.",
		);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-combobox:eq(1)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("none"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-comboitem:contains(Monday)").css("display"),
				)(),
			),
			"If 'Regular Week' is selected in the first combobox, the second combobox should contain 'Sunday' through 'Saturday'.",
		);
	await t.click(Selector(() => jq(".z-comboitem:contains(Monday)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk(
			"No exceptions should occur when changing the selection in any order.",
		);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-combobox:eq(1)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("none"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-comboitem:contains(Tuesday)").css("display"),
				)(),
			),
			"If 'Regular Week' is selected in the first combobox, the second combobox should contain 'Sunday' through 'Saturday'.",
		);
	await t.click(Selector(() => jq(".z-comboitem:contains(Tuesday)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk(
			"No exceptions should occur when changing the selection in any order.",
		);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-combobox:eq(1)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("none"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-comboitem:contains(Wednesday)").css("display"),
				)(),
			),
			"If 'Regular Week' is selected in the first combobox, the second combobox should contain 'Sunday' through 'Saturday'.",
		);
	await t.click(Selector(() => jq(".z-comboitem:contains(Wednesday)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk(
			"No exceptions should occur when changing the selection in any order.",
		);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-combobox:eq(1)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("none"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-comboitem:contains(Thursday)").css("display"),
				)(),
			),
			"If 'Regular Week' is selected in the first combobox, the second combobox should contain 'Sunday' through 'Saturday'.",
		);
	await t.click(Selector(() => jq(".z-comboitem:contains(Thursday)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk(
			"No exceptions should occur when changing the selection in any order.",
		);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-combobox:eq(1)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("none"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-comboitem:contains(Friday)").css("display"),
				)(),
			),
			"If 'Regular Week' is selected in the first combobox, the second combobox should contain 'Sunday' through 'Saturday'.",
		);
	await t.click(Selector(() => jq(".z-comboitem:contains(Friday)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk(
			"No exceptions should occur when changing the selection in any order.",
		);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-combobox:eq(1)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("none"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-comboitem:contains(Saturday)").css("display"),
				)(),
			),
			"If 'Regular Week' is selected in the first combobox, the second combobox should contain 'Sunday' through 'Saturday'.",
		);
	await t.click(Selector(() => jq(".z-comboitem:contains(Saturday)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk(
			"No exceptions should occur when changing the selection in any order.",
		);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-combobox:eq(0)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-comboitem:contains(Working)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk(
			"No exceptions should occur when changing the selection in any order.",
		);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-combobox:eq(1)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("none"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-comboitem:contains(Monday)").css("display"),
				)(),
			),
			"If 'Working Week' is selected in the first combobox, the second combobox should contain 'Monday' through 'Friday'.",
		);
	await t.click(Selector(() => jq(".z-comboitem:contains(Monday)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk(
			"No exceptions should occur when changing the selection in any order.",
		);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-combobox:eq(1)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("none"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-comboitem:contains(Tuesday)").css("display"),
				)(),
			),
			"If 'Working Week' is selected in the first combobox, the second combobox should contain 'Monday' through 'Friday'.",
		);
	await t.click(Selector(() => jq(".z-comboitem:contains(Tuesday)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk(
			"No exceptions should occur when changing the selection in any order.",
		);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-combobox:eq(1)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("none"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-comboitem:contains(Wednesday)").css("display"),
				)(),
			),
			"If 'Working Week' is selected in the first combobox, the second combobox should contain 'Monday' through 'Friday'.",
		);
	await t.click(Selector(() => jq(".z-comboitem:contains(Wednesday)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk(
			"No exceptions should occur when changing the selection in any order.",
		);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-combobox:eq(1)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("none"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-comboitem:contains(Thursday)").css("display"),
				)(),
			),
			"If 'Working Week' is selected in the first combobox, the second combobox should contain 'Monday' through 'Friday'.",
		);
	await t.click(Selector(() => jq(".z-comboitem:contains(Thursday)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk(
			"No exceptions should occur when changing the selection in any order.",
		);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-combobox:eq(1)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("none"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-comboitem:contains(Friday)").css("display"),
				)(),
			),
			"If 'Working Week' is selected in the first combobox, the second combobox should contain 'Monday' through 'Friday'.",
		);
	await t.click(Selector(() => jq(".z-comboitem:contains(Friday)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk(
			"No exceptions should occur when changing the selection in any order.",
		);
});
