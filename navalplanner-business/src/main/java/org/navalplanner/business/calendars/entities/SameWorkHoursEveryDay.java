/*
 * This file is part of NavalPlan
 *
 * Copyright (C) 2009-2010 Fundación para o Fomento da Calidade Industrial e
 *                         Desenvolvemento Tecnolóxico de Galicia
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.navalplanner.business.calendars.entities;

import org.apache.commons.lang.Validate;
import org.joda.time.LocalDate;
import org.navalplanner.business.workingday.EffortDuration;
import org.navalplanner.business.workingday.IntraDayDate.PartialDay;
import org.navalplanner.business.workingday.ResourcesPerDay;

public class SameWorkHoursEveryDay implements ICalendar {

    private static final SameWorkHoursEveryDay DEFAULT_WORKING_DAY = new SameWorkHoursEveryDay(
            8);

    public static SameWorkHoursEveryDay getDefaultWorkingDay() {
        return DEFAULT_WORKING_DAY;
    }
    private final Integer hours;

    public SameWorkHoursEveryDay(Integer hours) {
        Validate.notNull(hours);
        Validate.isTrue(hours >= 0);
        this.hours = hours;
    }

    @Override
    public EffortDuration getCapacityOn(LocalDate date) {
        return getCapacityOn(PartialDay.wholeDay(date));
    }

    @Override
    public EffortDuration getCapacityOn(PartialDay partialDay) {
        return partialDay.limitDuration(EffortDuration.hours(hours));
    }

    @Override
    public EffortDuration asDurationOn(LocalDate day, ResourcesPerDay amount) {
        return asDurationOn(PartialDay.wholeDay(day), amount);
    }

    @Override
    public EffortDuration asDurationOn(PartialDay day, ResourcesPerDay amount) {
        return amount.asDurationGivenWorkingDayOf(getCapacityOn(day));
    }

    @Override
    public boolean thereAreCapacityFor(AvailabilityTimeLine availability,
            ResourcesPerDay resourcesPerDay, EffortDuration durationToAllocate) {
        return true;
    }

    @Override
    public AvailabilityTimeLine getAvailability() {
        return AvailabilityTimeLine.allValid();
    }

}
