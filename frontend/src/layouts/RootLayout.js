import React from 'react';
import { Outlet } from 'react-router-dom';
import LegalNoticeFooter from '../components/LegalNoticeFooter';

function RootLayout() {
  return (
    <div className="app-shell">
      <main className="app-main">
        <Outlet />
        <LegalNoticeFooter />
      </main>
    </div>
  );
}

export default RootLayout;
