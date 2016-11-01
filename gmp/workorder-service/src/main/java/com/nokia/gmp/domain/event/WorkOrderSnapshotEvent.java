package com.nokia.gmp.domain.event;

import org.axonframework.eventstore.jpa.SnapshotEventEntry;

import javax.persistence.Entity;

/**
 * Created by fatih.dirlikli on 31/10/16.
 */
@Entity
public class WorkOrderSnapshotEvent extends SnapshotEventEntry {
}
