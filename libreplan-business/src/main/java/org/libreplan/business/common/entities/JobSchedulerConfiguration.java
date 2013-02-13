/*
 * This file is part of LibrePlan
 *
 * Copyright (C) 2013 St. Antoniusziekenhuis
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

package org.libreplan.business.common.entities;

import org.hibernate.validator.NotNull;
import org.libreplan.business.common.BaseEntity;

/**
 * JobSchedulerConfiguration entity, represents parameters for the jobs to be
 * scheduled. This entity is used by the <code>SchedulerManager</code> to
 * schedule jobs and in UI to show the scheduler status.
 *
 * The <code>jobGroup</code> and <code>jobName</code> together forms a job key
 * and non of the fields must be null. Moreover it should contain a valid
 * <code>cronExpression</code>
 *
 * @author Miciele Ghiorghis <m.ghiorghis@antoniusziekenhuis.nl>
 */
public class JobSchedulerConfiguration extends BaseEntity {

    public static JobSchedulerConfiguration create() {
        return create(new JobSchedulerConfiguration());
    }

    /**
     * Constructor for Hibernate. Do not use!
     */
    protected JobSchedulerConfiguration() {
    }

    private String jobGroup;

    private String jobName;

    private String triggerGroup;

    private String triggerName;

    private String cronExpression;

    private String jobClassName;

    @NotNull(message = "job group not specified")
    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    @NotNull(message = "job name not specified")
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @NotNull(message = "trigger group not specified")
    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    @NotNull(message = "trigger name not specified")
    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    @NotNull(message = "cron expression not specified")
    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    @NotNull(message = "job class name not specified")
    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }
}
