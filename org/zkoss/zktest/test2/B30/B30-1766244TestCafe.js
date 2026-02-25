import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1766244TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1766244.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1766244TestCafe", async (t) => {
	await ztl.initTest(t);
	let offset1x_cafe = await ClientFunction(
		() => zk(zk.Desktop._dt.$f("cb", true)).revisedOffset()[0],
	)();
	let offset1y_cafe = await ClientFunction(
		() => zk(zk.Desktop._dt.$f("cb", true)).revisedOffset()[1],
	)();
	let offset2x_cafe = await ClientFunction(
		() => zk(zk.Desktop._dt.$f("cb", true).$n("btn")).revisedOffset()[0],
	)();
	let offset2y_cafe = await ClientFunction(
		() => zk(zk.Desktop._dt.$f("cb", true).$n("btn")).revisedOffset()[1],
	)();
	await ztl.doScroll({
		locator: Selector(() => zk.Desktop._dt.$f("grid", true).$n()),
		scrollType: "vertical",
		dist: "20",
	});
	await ztl.waitResponse(t);
	let offset3x_cafe = await ClientFunction(
		() => zk(zk.Desktop._dt.$f("cb", true)).revisedOffset()[0],
	)();
	let offset3y_cafe = await ClientFunction(
		() => zk(zk.Desktop._dt.$f("cb", true)).revisedOffset()[1],
	)();
	let offset4x_cafe = await ClientFunction(
		() => zk(zk.Desktop._dt.$f("cb", true).$n("btn")).revisedOffset()[0],
	)();
	let offset4y_cafe = await ClientFunction(
		() => zk(zk.Desktop._dt.$f("cb", true).$n("btn")).revisedOffset()[1],
	)();
	await t
		.expect(ztl.normalizeText(offset3x_cafe))
		.eql(ztl.normalizeText(offset1x_cafe));
	await t
		.expect(ztl.normalizeText(offset4x_cafe))
		.eql(ztl.normalizeText(offset2x_cafe));
	let verifyVariable_cafe_0_0 = parseInt(
		await ClientFunction(
			() => zk(zk.Desktop._dt.$f("cb", true)).revisedOffset()[1],
		)(),
	);
	let verifyVariable_cafe_1_1 = parseInt(
		await ClientFunction(
			() => zk(zk.Desktop._dt.$f("cb", true)).revisedOffset()[1],
		)(),
	);
	await t
		.expect(ztl.normalizeText(offset3y_cafe))
		.eql(ztl.normalizeText(parseInt(offset1y_cafe) - 20));
	let verifyVariable_cafe_2_2 = parseInt(
		await ClientFunction(
			() =>
				zk(zk.Desktop._dt.$f("cb", true).$n("btn")).revisedOffset()[1],
		)(),
	);
	let verifyVariable_cafe_3_3 = parseInt(
		await ClientFunction(
			() =>
				zk(zk.Desktop._dt.$f("cb", true).$n("btn")).revisedOffset()[1],
		)(),
	);
	await t
		.expect(ztl.normalizeText(offset4y_cafe))
		.eql(ztl.normalizeText(parseInt(offset2y_cafe) - 20));
	await ztl.doScroll({
		locator: Selector(() => zk.Desktop._dt.$f("grid", true).$n()),
		scrollType: "vertical",
		dist: "0",
	});
	await ztl.waitResponse(t);
	offset3x_cafe = await ClientFunction(
		() => zk(zk.Desktop._dt.$f("cb", true)).revisedOffset()[0],
	)();
	offset3y_cafe = await ClientFunction(
		() => zk(zk.Desktop._dt.$f("cb", true)).revisedOffset()[1],
	)();
	offset4x_cafe = await ClientFunction(
		() => zk(zk.Desktop._dt.$f("cb", true).$n("btn")).revisedOffset()[0],
	)();
	offset4y_cafe = await ClientFunction(
		() => zk(zk.Desktop._dt.$f("cb", true).$n("btn")).revisedOffset()[1],
	)();
	await t
		.expect(ztl.normalizeText(offset3x_cafe))
		.eql(ztl.normalizeText(offset1x_cafe));
	await t
		.expect(ztl.normalizeText(offset3y_cafe))
		.eql(ztl.normalizeText(offset1y_cafe));
	await t
		.expect(ztl.normalizeText(offset4x_cafe))
		.eql(ztl.normalizeText(offset2x_cafe));
	await t
		.expect(ztl.normalizeText(offset4y_cafe))
		.eql(ztl.normalizeText(offset2y_cafe));
});
