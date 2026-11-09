package com.caos.batallanaval.domain.mechanics

import com.caos.batallanaval.domain.model.SpecialMechanic
import com.caos.batallanaval.domain.model.SpecialMechanicType

class MechanicManager {
    fun getRandomMechanics(): List<SpecialMechanic> {
        return listOf(
            SpecialMechanic(type = SpecialMechanicType.NEW_LIFE)
        )
    }
}