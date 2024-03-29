package com.github.syafiqq.androidarchtest001.di.module

import com.github.syafiqq.androidarchtest001.dump.concrete.TitleConcrete1
import com.github.syafiqq.androidarchtest001.dump.contract.TitleContract1
import dagger.Module
import dagger.Provides

@Module
class TitleModule1 {
    @Provides
    fun provideTitleContract(): TitleContract1 {
        return TitleConcrete1(100)
    }
}