import gregtech.api.GregTechAPI;
import gregtech.api.unification.material.Material;
import static globals.Globals.*
import static globals.SinteringGlobals.*

import static gregtech.api.unification.material.Materials.*;
import static globals.Globals.*

VACUUM_FREEZER = recipemap('vacuum_freezer')
CSTR = recipemap('continuous_stirred_tank_reactor')
TBR = recipemap('trickle_bed_reactor')
FBR = recipemap('fixed_bed_reactor')
BCR = recipemap('bubble_column_reactor')
BR = recipemap('batch_reactor')
ROTARY_KILN = recipemap('rotary_kiln')
MACERATOR = recipemap('macerator')
DISTILLATION_TOWER = recipemap('distillation_tower')
DISTILLERY = recipemap('distillery')
ROASTER = recipemap('roaster')
MIXER = recipemap('mixer')
DRYER = recipemap('dryer')
SIFTER = recipemap('sifter')
CENTRIFUGE = recipemap('centrifuge')
PYROLYSE = recipemap('pyrolyse_oven')
LCR = recipemap('large_chemical_reactor')
EBF = recipemap('electric_blast_furnace')
VULCANIZER = recipemap('vulcanizing_press')
ALLOY_SMELTER = recipemap('alloy_smelter')
ARC_FURNACE = recipemap('arc_furnace')
AUTOCLAVE = recipemap('autoclave')
COMPRESSOR = recipemap('compressor')
ASSEMBLER = recipemap('assembler')
ELECTROLYZER = recipemap('electrolyzer')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
REACTION_FURNACE = recipemap('reaction_furnace')
ELECTROMAGNETIC_SEPARATOR = recipemap('electromagnetic_separator')
PSA = recipemap('pressure_swing_adsorption')
CHEMICAL_BATH = recipemap('chemical_bath')
FLOTATION = recipemap('froth_flotation')
ADVANCED_ARC_FURNACE = recipemap('advanced_arc_furnace')

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustVanadinite') * 21)
        .inputs(ore('dustSalt') * 6)
        .outputs(metaitem('dustSaltRoastedVanadinite') * 27)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustVanadinite') * 42)
        .inputs(ore('dustSodaAsh') * 18)
        .outputs(metaitem('dustSodaAshRoastedVanadinite') * 51)
        .fluidOutputs(fluid('carbon_dioxide') * 3000)
        .duration(300)
        .EUt(120)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustSodaAshRoastedVanadinite') * 51)
        .fluidInputs(fluid('water') * 6000)
        .fluidOutputs(fluid('sodium_vanadate_solution') * 6000)
        .outputs(metaitem('dustLeachedSodaAshRoastedVanadinite') * 21)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustLeachedSodaAshRoastedVanadinite') * 21)
        .fluidInputs(fluid('gtfo_heated_water') * 1000)
        .fluidOutputs(fluid('lead_chloride_solution') * 1000)
        .outputs(metaitem('dustLeadOxide') * 18)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustSaltRoastedVanadinite') * 27)
        .fluidInputs(fluid('water') * 3000)
        .fluidOutputs(fluid('sodium_vanadate_solution') * 3000)
        .outputs(metaitem('dustLeachedSaltRoastedVanadinite') * 12)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustLeachedSaltRoastedVanadinite') * 12)
        .fluidInputs(fluid('gtfo_heated_water') * 3000)
        .fluidOutputs(fluid('lead_chloride_solution') * 3000)
        .outputs(metaitem('dustLeadOxide') * 6)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('lead_chloride_solution') * 1000)
        .fluidOutputs(fluid('water') * 1000)
        .outputs(metaitem('dustLeadChloride') * 3)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustAmmoniumChloride') * 6)
        .fluidInputs(fluid('sodium_vanadate_solution') * 1000)
        .outputs(metaitem('dustAmmoniumMetavanadate') * 9)
        .fluidOutputs(fluid('salt_water') * 1000)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustAmmoniumMetavanadate') * 18)
        .outputs(metaitem('dustVanadiumPentoxide') * 7)
        .fluidOutputs(fluid('steam') * 1000)
        .fluidOutputs(fluid('ammonia') * 2000)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

ELECTROMAGNETIC_SEPARATOR.recipeBuilder()
        .inputs(ore('dustImpureVanadiferousTitanomagnetite'))
        .outputs(metaitem('dustVanadiferousTitanomagnetite'))
        .chancedOutput(metaitem('dustPegmatiteTailings'), 2500, 500)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('distilled_water') * 2000)
        .inputs(ore('dustVanadiferousTitanomagnetite') * 8)
        .fluidOutputs(fluid('impure_vanadiferous_titanomagnetite_slurry') * 2000)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

FLOTATION.recipeBuilder()
        .fluidInputs(fluid('impure_vanadiferous_titanomagnetite_slurry') * 2000)
        .notConsumable(fluid('methyl_isobutyl_carbinol') * 100)
        .notConsumable(fluid('n_octylamine') * 100)
        .fluidOutputs(fluid('vanadiferous_titanomagnetite_slurry') * 1000)
        .fluidOutputs(fluid('silicon_dioxide_slurry') * 1000)
        .EUt(480)
        .duration(800)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('silicon_dioxide_slurry') * 1000)
        .fluidOutputs(fluid('wastewater') * 1000)
        .outputs(metaitem('dustSiliconDioxide'))
        .EUt(120)
        .duration(400)
        .buildAndRegister()

CLARIFIER.recipeBuilder()
        .fluidInputs(fluid('vanadiferous_titanomagnetite_slurry') * 1000)
        .fluidOutputs(fluid('wastewater') * 1000)
        .outputs(metaitem('dustFlotatedVanadiferousTitanomagnetite') * 16)
        .EUt(30)
        .duration(20)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustMagnesite'))
        .outputs(metaitem('dustMagnesiumCarbonate'))
        .EUt(30)
        .duration(160)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustMagnesiumChloride') * 3)
        .fluidInputs(fluid('sodium_bicarbonate_solution') * 2000)
        .outputs(metaitem('dustMagnesiumCarbonate') * 5)
        .fluidOutputs(fluid('salt_water') * 2000)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .EUt(30)
        .duration(160)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustMagnesiumHydroxide') * 5)
        .fluidInputs(fluid('carbon_dioxide') * 1000)
        .outputs(metaitem('dustMagnesiumCarbonate') * 5)
        .fluidOutputs(fluid('steam') * 1000)
        .EUt(30)
        .duration(160)
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(ore('dustCalcite') * 5)
        .inputs(ore('dustMagnesiumCarbonate') * 5)
        .outputs(metaitem('dustDolomite') * 10)
        .EUt(120)
        .duration(300)
        .buildAndRegister()

for (fuel in sintering_fuels) {
    if (!fuel.isPlasma) {
        for (comburent in sintering_comburents) {
            ROTARY_KILN.recipeBuilder()
                    .inputs(ore('dustFlotatedVanadiferousTitanomagnetite') * 11)
                    .inputs(ore('dustCoke') * 7)
                    .inputs(ore('dustDolomite'))
                    .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
                    .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
                    .outputs(metaitem('vti_rich_pig_iron') * 4)
                    .fluidOutputs(fluid('carbon_monoxide') * 7000)
                    .duration(fuel.duration + comburent.duration)
                    .EUt(120)
                    .buildAndRegister()

            ROTARY_KILN.recipeBuilder()
                    .inputs(ore('dustFlotatedVanadiferousTitanomagnetite') * 11)
                    .inputs(ore('dustCarbon') * 7)
                    .inputs(ore('dustDolomite'))
                    .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
                    .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
                    .outputs(metaitem('vti_rich_pig_iron') * 4)
                    .fluidOutputs(fluid('carbon_monoxide') * 7000)
                    .duration(fuel.duration + comburent.duration)
                    .EUt(120)
                    .buildAndRegister()

            ROTARY_KILN.recipeBuilder()
                    .inputs(ore('dustVtSlag'))
                    .inputs(ore('dustSodaAsh') * 5)
                    .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
                    .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
                    .outputs(metaitem('dustAlkaliVtSlag'))
                    .fluidOutputs(fluid('carbon_dioxide') * 1000)
                    .duration(fuel.duration + comburent.duration)
                    .EUt(120)
                    .buildAndRegister()
        }
    }
}

ADVANCED_ARC_FURNACE.recipeBuilder()
        .inputs(metaitem('vti_rich_pig_iron') * 2)
        .fluidInputs(fluid('oxygen') * 2700)
        .outputs(metaitem('ingotSteel') * 2)
        .outputs(metaitem('vt_slag'))
        .EUt(240)
        .duration(300)
        .buildAndRegister()

MACERATOR.recipeBuilder()
        .inputs(metaitem('vt_slag'))
        .outputs(metaitem('dustVtSlag'))
        .EUt(120)
        .duration(200)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustAlkaliVtSlag') * 7)
        .fluidInputs(fluid('distilled_water') * 1000)
        .outputs(metaitem('dustTitaniaSlag') * 6)
        .fluidOutputs(fluid('sodium_vanadate_solution') * 1000)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustTitaniaSlag'))
        .fluidInputs(fluid('oleum') * 1000)
        .outputs(metaitem('dustSiliconDioxide'))
        .fluidOutputs(fluid('titanyl_sulfate_solution') * 1000)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustHighPurityCalcium') * 5)
        .inputs(ore('dustVanadiumPentoxide') * 7)
        .outputs(metaitem('dustVanadium') * 2)
        .outputs(metaitem('dustQuicklime') * 10)
        .EUt(120)
        .duration(100)
        .buildAndRegister()