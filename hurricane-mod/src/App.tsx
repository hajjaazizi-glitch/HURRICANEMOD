import React from 'react';
import { Package, Download, Github } from 'lucide-react';

export default function App() {
  return (
    <div className="min-h-screen bg-neutral-900 text-neutral-100 p-8 flex flex-col items-center justify-center font-sans">
      <div className="max-w-2xl text-center space-y-6">
        <div className="flex justify-center mb-8">
          <div className="bg-emerald-500/20 p-4 rounded-full">
            <Package className="w-16 h-16 text-emerald-400" />
          </div>
        </div>
        
        <h1 className="text-4xl font-bold tracking-tight">
          Minecraft Mod Generated
        </h1>
        
        <p className="text-xl text-neutral-400">
          Your Forge 1.20.1 workspace for <strong>HurricaneMod</strong> is ready.
        </p>

        <div className="bg-neutral-800 p-6 rounded-xl text-left border border-neutral-700/50 mt-8 space-y-4 shadow-xl">
          <h3 className="font-semibold text-lg text-emerald-400 flex items-center gap-2">
            What's inside?
          </h3>
          <ul className="list-inside list-disc text-neutral-300 space-y-2">
            <li>Complete <code className="bg-neutral-900 px-1.5 py-0.5 rounded text-sm">build.gradle</code> configured for Forge 1.20.1</li>
            <li>Particle effects simulating a rising cyclone/hurricane using vanilla Minecraft particles</li>
            <li>Client-side commands: <code className="bg-neutral-900 px-1.5 py-0.5 rounded text-sm">/hurricane start</code> and <code className="bg-neutral-900 px-1.5 py-0.5 rounded text-sm">/hurricane stop</code></li>
            <li>GitHub Action workflow for automated <code className="bg-neutral-900 px-1.5 py-0.5 rounded text-sm">.jar</code> builds</li>
          </ul>
        </div>

        <div className="text-neutral-500 pt-8 mt-8 border-t border-neutral-800 flex flex-col sm:flex-row items-center gap-4 justify-center">
          <div className="flex items-center gap-2">
            <Download className="w-5 h-5" /> Export to ZIP
          </div>
          <div className="hidden sm:block text-neutral-700">•</div>
          <div className="flex items-center gap-2">
            <Github className="w-5 h-5" /> Push to GitHub to compile
          </div>
        </div>
      </div>
    </div>
  );
}
