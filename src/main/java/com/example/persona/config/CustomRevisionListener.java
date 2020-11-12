package com.example.persona.config;

import org.hibernate.envers.RevisionListener;

import com.example.persona.auditory.Revision;

public class CustomRevisionListener implements RevisionListener{

	@Override
	public void newRevision(Object revisionEntity) {
		
		final Revision revision = (Revision) revisionEntity; 
		
	}

}
